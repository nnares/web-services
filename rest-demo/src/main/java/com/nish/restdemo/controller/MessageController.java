package com.nish.restdemo.controller;

import com.nish.restdemo.model.Message;
import com.nish.restdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/text"})
    public String getTestResponse() {
        return "Test Response String";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{messageId}")
    public Message getMessageById(@PathVariable("messageId") int id) {
        return messageService.getMessageById(id);
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/messages/{messageId}")
    public Message updateMessage(@RequestBody Message message, @PathVariable("messageId") int id) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

//    @PatchMapping("/messages/{messageId}")
    @RequestMapping(method = RequestMethod.PATCH, value = "/messages/{messageId}")
    public Message updateMessageText(@RequestBody String messageText, @PathVariable("messageId") int id) {
        Message message =  messageService.getMessageById(id);
        // patch logic is only applied over the message attribute,
        // so what ever we will pass from post man that is gets updated for message attribute
        message.setMessage(messageText);
        return messageService.updateMessage(message);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/messages/{messageId}")
    public Message deleteMessage(@PathVariable("messageId") int id) {
        return messageService.deleteMessage(id);
    }
}

