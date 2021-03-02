package com.nish.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private int commentId;
    private String message;
    private String posted;

    public Comment() {
    }

    public Comment(int commentId, String message, String posted) {
        this.commentId = commentId;
        this.message = message;
        this.posted = posted;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", posted='" + posted + '\'' +
                '}';
    }
}
