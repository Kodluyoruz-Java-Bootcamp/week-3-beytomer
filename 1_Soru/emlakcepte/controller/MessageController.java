package com.emlakcepte.controller;

import com.emlakcepte.model.Message;
import com.emlakcepte.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Message message){
        messageService.createMessage(message);
    }
    @DeleteMapping
    public void delete(@RequestBody Message message){
        messageService.delete(message);
    }
}
