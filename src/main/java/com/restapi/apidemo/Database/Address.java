package com.restapi.apidemo.Database;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String last_name;
    private String first_name;


    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private schoolentity schoolentity;


    public Address(){
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public Address(int id, String last_name, String first_name) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
    }
    public schoolentity getSchoolentity() {
        return schoolentity;
    }
    public void setSchoolentity(schoolentity schoolentity) {
        this.schoolentity = schoolentity;
    }
    
    
}
