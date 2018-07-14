package com.socialnetwork;

import java.util.List;

public class ReadUserWall implements UseCase {
    private final String user;
    private final Wall wall;
    private final ReadUserWallEvents events;

    public ReadUserWall(String user, Wall wall, ReadUserWallEvents events) {
        this.user = user;
        this.wall = wall;
        this.events = events;
    }

    public void run() {
        List<WallMessage> messages = wall.allMessagesOf(user);
        events.onReadUserWall(messages);
    }
}
