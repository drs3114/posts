package com.deepakshankar.posts.model;

public enum PostType {
    BLOG(0,"BLOG", "A blog post"),
    POEM(1,"POEM","A poem post");
    public int id;
    public String name;
    public String description;

    PostType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
