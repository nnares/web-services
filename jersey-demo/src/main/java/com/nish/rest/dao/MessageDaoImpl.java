package com.nish.rest.dao;

import com.nish.rest.model.Message;

import java.util.*;

public class MessageDaoImpl implements MessageDao {

    private Map<Integer, Message> messageTable = DataBase.getMessageTable();

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messageTable.values());
    }

    @Override
    public Message getMessageById(int id) {
        return messageTable.get(id);
    }

    @Override
    public Message createMessage(Message message) {
        message.setId(messageTable.size() + 1);
        messageTable.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messageTable.put(message.getId(), message);
        return message;
    }

    @Override
    public Message deleteMessage(int id) {
        return messageTable.remove(id);
    }

/*

    public static void main(String[] args) {

        MessageDaoImpl messageDao = new MessageDaoImpl();
        messageDao.printList();

        // Add
        Message message = new Message(4, "Delhi goes top in points table", "Ricky Pointing", "Sun Oct 04 10:44:31 IST 2020");
        messageDao.createMessage(message);
        messageDao.printList();

        // Update
        message.setAuthor("Md Kaif");
        message.setMessage("Delhi table topper");
        messageDao.printList();

        // Delete
        messageDao.deleteMessage(4);
        messageDao.printList();

    }

    private void printList() {
        System.out.println("-------------current list -------------");
        for(Message m : getAllMessages()){
            System.out.println( m);
        }
    }

*/

}