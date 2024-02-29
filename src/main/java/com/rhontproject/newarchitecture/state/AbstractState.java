package com.rhontproject.newarchitecture.state;

import com.rhontproject.MessageService;
import com.rhontproject.stateMethods.GlobalVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.rhontproject.stateMethods.GlobalVariable.messageService;

@Component
public abstract class AbstractState implements StateAction {
    protected MessageService messageService= GlobalVariable.messageService;
    protected int count;
    protected String message;
}
