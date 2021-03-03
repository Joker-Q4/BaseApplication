package com.joker.fake.location.bean;

/**
 * @author Joker
 * @since 2021/03/03
 */
public class ToolBar {

    private String left;
    private String title;
    private String right;

    public ToolBar(String left, String title, String right) {
        this.left = left;
        this.title = title;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
