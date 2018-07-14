package com.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    List<WallMessage> messages = new ArrayList<WallMessage>();

    public void add(WallMessage message) {
        messages.add(message);
    }

    public List<WallMessage> allMessagesOf(String user) {
        return new ArrayList<WallMessage>(messages);
    }
}
