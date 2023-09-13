package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Tank {
    private String direction;
    private float pwm;
    private float leftValue;
    private float rightValue;

    public Tank() {
        this("stop", 100, 0, 0);
    }

    public void update(String direction, float pwm) {
        this.direction = direction;
        this.pwm = pwm;
    }

    public void evaluateVelocity() {

        switch(direction) {
            case("forward"):
                leftValue = pwm;
                rightValue = pwm;
                break;

            case("left"):
                leftValue = -pwm;
                rightValue = pwm;
                break;

            case("right"):
                leftValue = pwm;
                rightValue = -pwm;
                break;

            case("backwards"):
                leftValue = -pwm;
                rightValue = -pwm;
                break;

            default:
                leftValue = 0;
                rightValue = 0;
        }
    }

    public TankResponse getResponse() {
        return new TankResponse(leftValue, rightValue);
    }
}
