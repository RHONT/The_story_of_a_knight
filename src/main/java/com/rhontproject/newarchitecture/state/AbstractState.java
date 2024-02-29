package com.rhontproject.newarchitecture.state;

import com.rhontproject.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractState implements StateAction {
    @Autowired
    protected MessageService messageService;
    protected int count;
    protected String message;
}
