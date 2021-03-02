package com.nish.rest.service;

import com.nish.rest.dao.MessageDao;
import com.nish.rest.dao.MessageDaoImpl;
import com.nish.rest.model.Message;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

public class MessageService {

    private MessageDao messageDao;

    public MessageService() {
        this.messageDao = new MessageDaoImpl();
    }

    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    public Message getMessageById(int id) {
        return messageDao.getMessageById(id);
    }

    public Message createMessage(Message message) {
        return messageDao.createMessage(message);
    }

    public Message updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }

    public Message deleteMessage(int id) {
        return messageDao.deleteMessage(id);
    }


}
