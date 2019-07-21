package com.deepakshankar.posts.exception;

public enum PostsErrorCode {
    POSTS_OK(200,"POSTS OK", "Posts Application in good state"),
    POSTS_ILLEGAL,
    POOSTS_NOT_FOUND,
    POSTS_GENERIC_ERROR;
    private int id;
    private String name;
    private String description;

    PostsErrorCode() {

    }
    PostsErrorCode(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
