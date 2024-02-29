package com.rhontproject.unit.Statless;

import com.rhontproject.service.MessageService;
import com.rhontproject.fabrics.GlobalVariable;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractState implements StateAction {
    protected MessageService messageService= GlobalVariable.messageService;
    protected int count;
    protected String message;
}
