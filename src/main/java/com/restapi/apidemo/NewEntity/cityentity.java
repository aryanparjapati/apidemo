package com.restapi.apidemo.NewEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class cityentity {

    @Id
    private int id;
    private String name;
    private String address;

    public cityentity(){

    }

    public cityentity(int id, String name, String address){
        this.id = id; 
        this.name = name; 
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "cityentity [name=" + name + ", id=" + id + ", address=" + address + "]";
    }
    
    
}
