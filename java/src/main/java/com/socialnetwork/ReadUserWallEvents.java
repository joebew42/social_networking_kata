package com.socialnetwork;

import java.util.List;

public interface ReadUserWallEvents {
    void onReadUserWall(List<WallMessage> messages);
}
