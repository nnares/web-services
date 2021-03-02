package com.nish.rest.resource;

import com.nish.rest.dao.DataBase;
import com.nish.rest.model.Comment;
import com.nish.rest.model.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;


@Path("/")
public class CommentResource {

    private Map<Integer, List<Comment>>  commentTable = DataBase.getCommentTable();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentsByMessageId(@PathParam("messageId") int messageId) {
        return commentTable.get(messageId);
    }

    @GET
    @Path("/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getSpecificCommentsByCommentId(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
        return commentTable.get(messageId).get(commentId);
    }

}