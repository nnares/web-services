package com.nish.rest.resource;

import com.nish.rest.model.Message;
import com.nish.rest.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource {

    MessageService messageService = new MessageService();

/*
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getAllMessagesXml() {
        return messageService.getAllMessages();
    }
*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessagesJson() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageById(@PathParam("messageId") int id) {
        return messageService.getMessageById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {
        return messageService.createMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") int id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId") int id) {
        return messageService.deleteMessage(id);
    }

    // implementing sub-resources
    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}