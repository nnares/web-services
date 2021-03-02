package com.nish.rest.dao;

import com.nish.rest.model.Message;

import java.util.List;

public interface MessageDao {

    public List<Message> getAllMessages();

    public Message getMessageById(int id);

    public Message createMessage(Message message);

    public Message updateMessage(Message message);

    public Message deleteMessage(int id);

}