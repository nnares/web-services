package com.nish.rest.dao;

import com.nish.rest.model.Comment;
import com.nish.rest.model.Message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

    private static Map<Integer, Message> messageTable;
    private static Map<Integer, List<Comment>> commentTable;

    static{
        messageTable = new HashMap<>();
        messageTable.put(1, new Message(1, "IPL is kicking off tomorrow", "M S Dhoni", "18/08/2020"));
        messageTable.put(2, new Message(2, "Todays poll - Mountain / Beach ?", "Aprajita Lilly", "18/09/2020"));
        messageTable.put(3, new Message(3, "Happy Independence Day", "Virat Kohli", "15/08/2020"));

        commentTable = new HashMap<>();
        List<Comment> comments = Arrays.asList(
                new Comment(1, "Like Mountains", "18/08/2020"),
                new Comment(2, "Like Beach", "18/09/2020"),
                new Comment(3, "Not Liking anything", "18/09/2020")
        );
        commentTable.put(2, comments);
    }

    public static Map<Integer, Message> getMessageTable() {
        return messageTable;
    }

    public static Map<Integer, List<Comment>> getCommentTable() {
        return commentTable;
    }
}
