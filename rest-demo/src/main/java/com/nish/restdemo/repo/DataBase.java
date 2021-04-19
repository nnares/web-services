package com.nish.restdemo.repo;


import com.nish.restdemo.model.Message;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static Map<Integer, Message> messageTable;

    static{
        messageTable = new HashMap<>();
        messageTable.put(1, new Message(1, "IPL is kicking off tomorrow", "BCCI", "18/09/2020"));
        messageTable.put(2, new Message(2, "Today's poll - Mountain / Beach ?", "Time Of India", "31/11/2020"));
        messageTable.put(3, new Message(3, "Covid vaccine will start from tomorrow", "Indian Govt", "14/01/2021"));
        messageTable.put(4, new Message(4, "New financial year start today", "RBI", "01/04/2021"));
    }

    public static Map<Integer, Message> getMessageTable() {
        return messageTable;
    }

}
