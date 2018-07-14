package com.socialnetwork;

import java.util.List;

public class ReadUserWall implements UseCase {
    private final String user;
    private final Wall wall;
    private final ReadUserWallCallbacks callbacks;

    public ReadUserWall(String user, Wall wall, ReadUserWallCallbacks callbacks) {
        this.user = user;
        this.wall = wall;
        this.callbacks = callbacks;
    }

    public void run() {
        List<WallMessage> messages = wall.allMessagesOf(user);
        callbacks.onReadUserWall(messages);
    }
}
