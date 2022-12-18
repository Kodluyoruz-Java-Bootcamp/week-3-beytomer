package com.emlakcepte.service;

import com.emlakcepte.model.Message;
import com.emlakcepte.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;

    public void createMessage(Message message){
        messageRepository.saveMessage(message);
    }

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public void delete(Message message){
        messageRepository.delete(message);
    }
}
