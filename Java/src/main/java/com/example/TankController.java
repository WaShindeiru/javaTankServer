package com.example;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path="/")
@AllArgsConstructor
public class TankController implements CommandLineRunner {

    private PythonTank tank;

    @PostMapping(path="forward")
    public void forward() throws IOException {
        tank.forward();
    }

    @PostMapping(path="backwards")
    public void backwards() throws IOException {
        tank.backwards();
    }

    @PostMapping(path="left")
    public void left() throws IOException {
        tank.left();
    }

    @PostMapping(path="right")
    public void right() throws IOException {
        tank.right();
    }

    @PostMapping(path="stop")
    public void stop() throws IOException {
        tank.stop();
    }

    @PostMapping(path="close")
    public void close() throws IOException {
        tank.closeConnection();
    }

    @Override
    public void run(String... args) throws Exception {
//
//        tank.forward();
//        Thread.sleep(500);
//
//        tank.backwards();
//        Thread.sleep(500);
//
//        tank.left();
//        Thread.sleep(500);
//
//        tank.right();
//        Thread.sleep(500);
    }
}
