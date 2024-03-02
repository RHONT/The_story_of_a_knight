package com.rhontproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EventKnightServiceTest {

    @Test
    void levelUp() {
    }

    @Test
    void halt() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EventKnightService eventKnightService = (EventKnightService) context.getBean("eventKnightService");
        eventKnightService.halt();
    }

    @Test
    void market() {
        int[] a={1,2};
        a=Arrays.stream(a).map(e->e-1).toArray();
        System.out.println(Arrays.toString(a));
    }
}