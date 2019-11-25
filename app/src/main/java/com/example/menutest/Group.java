package com.example.menutest;

public class Group {

    private String name;
    private int id;
    private int photo;

    public Group() {
    }

    public Group(String name, int id, int photo) {
        this.name = name;
        this.id = id;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
