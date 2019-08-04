package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimestampRestController {

    @GetMapping("/timestamp")
    public TimestampResponse timestamp() {
        return new TimestampResponse(System.currentTimeMillis());
    }

}
