package com.example;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@AllArgsConstructor
@RestController
@RequestMapping("")
public class MainController {

    private final ThreadPoolExecutor executor;
    private final Object lock;
    private final Tank tank;

    public MainController() {
        this(
                (ThreadPoolExecutor) Executors.newFixedThreadPool(4),
                new Object(),
                new Tank()
        );
    }

    @PostMapping(
            value = "/update"
    )
    public ResponseEntity<?> update(@RequestBody TankJSON tankJson) {
        synchronized(lock) {
            tank.update(tankJson.getDirection(), tankJson.getPwm());
            tank.evaluateVelocity();
            lock.notifyAll();
            System.out.println(tank.getDirection());

            return ResponseEntity.ok("Status Updated");
        }
    }

    @GetMapping(
            value = "/tank"
    )
    @ResponseBody
    public DeferredResult<ResponseEntity<TankResponse>> getTankResponse() {

        DeferredResult<ResponseEntity<TankResponse>> output = new DeferredResult<>(10000L);
        output.onTimeout(() -> {
            output.setErrorResult(ResponseEntity.noContent().build());
        });

        executor.submit(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    output.setResult(new ResponseEntity<>(tank.getResponse(), HttpStatus.OK));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return output;
    }
}
