package com.emlakcepte.repository;

import com.emlakcepte.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private static List<Message>messageList=new ArrayList<>();
    public void saveMessage(Message message){
        messageList.add(message);
    }
    public List<Message> getAll(){
        return messageList;
    }
    public void delete(Message message){
        messageList.remove(message);
    }
}
