package com.socialnetwork;

public class WallMessage {
    private final String user;
    private final String text;

    public WallMessage(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public String text() {
        return new String(text);
    }
}
