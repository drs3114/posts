package com.deepakshankar.posts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP")
public class App {

    private Long id;
    private String name;
    private AppInfo info;

    public App() {
        this(null);
    }

    public App(String name) {
        this(null, name, null);
    }

    public App(Long id, String name, AppInfo info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "APP_NM")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "APP_INFO")
    public AppInfo getInfo() {
        return info;
    }

    public void setInfo(AppInfo info) {
        this.info = info;
    }
}
