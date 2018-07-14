package com.socialnetwork;

public class PostMessageAs implements UseCase {
    private final String user;
    private final String message;
    private final Wall wall;

    public PostMessageAs(String user, String message, Wall wall) {
        this.user = user;
        this.message = message;
        this.wall = wall;
    }

    public void run() {
        wall.add(new WallMessage(user, message));
    }
}
