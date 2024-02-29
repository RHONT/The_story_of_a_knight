package com.rhontproject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class MessageService {
    private final List<String> messages=new ArrayList<>();

    public void outputConsole(){
        messages.forEach(System.out::println);
        messages.clear();
    }

    public void add(String string){
        messages.add(string);
    }
}
