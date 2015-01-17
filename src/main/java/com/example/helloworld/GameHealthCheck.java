package com.example.helloworld;

import com.codahale.metrics.health.HealthCheck;

public class GameHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        if (1 != 1) {
            return Result.unhealthy("unhealthy");
        }
        return Result.healthy();
    }
}
