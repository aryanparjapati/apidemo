package com.restapi.apidemo.entities;

public class BookEntities {

    private int id;
    private String name;
    private String author;


    public BookEntities(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public BookEntities(){
        
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "BookEntities [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
    

    
    
}
