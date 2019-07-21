package com.deepakshankar.posts.model;

public enum AppCategory {

    ENTERTAINMENT(0,"ENTERTAINMENT","Entertainment category"),
    PERSONAL_BLOG(1,"PERSONAL BLOG", "Personal Blog category"),
    ADULT(2,"ADULT", "Adult Category");

    private int id;
    private String name;
    private String description;
    private int minAge;
    private boolean ageRestricted;

    AppCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    AppCategory(int id, String name, String description, int minAge, boolean ageRestricted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.ageRestricted = ageRestricted;
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

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public boolean isAgeRestricted() {
        return ageRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
    }
}
