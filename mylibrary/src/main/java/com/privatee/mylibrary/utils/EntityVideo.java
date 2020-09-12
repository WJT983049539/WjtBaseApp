package com.privatee.mylibrary.utils;

import java.io.Serializable;

/**
 * 创建一个视频信息储存类
 */
public class EntityVideo implements Serializable {
    private String ThumbPath;
    private String path;
    private int Duration;

    public String getThumbPath() {
        return ThumbPath;
    }

    public void setThumbPath(String thumbPath) {
        ThumbPath = thumbPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }
}
