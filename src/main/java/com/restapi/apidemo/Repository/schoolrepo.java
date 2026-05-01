package com.restapi.apidemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.apidemo.Database.schoolentity;

public interface schoolrepo extends JpaRepository<schoolentity,Integer> {
    
    public schoolentity findById(int id);
}
