package com.example.newday;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewDayController {

    private static final String dayTemplate = "Soon it will be %s";

    @GetMapping("/new-day")
    public NewDay newday(@RequestParam String dayOld,
                         @RequestParam int dayAdded) {

        NewDay newCompDay = new NewDay(dayOld, dayAdded);
        newCompDay.getDayCount();
        return new NewDay(dayOld, dayAdded);

    }

}