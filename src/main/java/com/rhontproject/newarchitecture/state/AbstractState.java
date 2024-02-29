package com.rhontproject.newarchitecture.state;

import com.rhontproject.service.MessageService;
import com.rhontproject.stateMethods.GlobalVariable;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractState implements StateAction {
    protected MessageService messageService= GlobalVariable.messageService;
    protected int count;
    protected String message;
}
