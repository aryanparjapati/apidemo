package com.restapi.apidemo.Databaseservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.apidemo.Database.schoolentity;
import com.restapi.apidemo.Repository.schoolrepo;

@Component
public class servi {

    @Autowired
    private schoolrepo schoolrepo;

    

//GET ALL 
public List<schoolentity>getAllSchoolentities(){
    return schoolrepo.findAll();
}
    
//GET BY ID

public schoolentity getSchoolentityById(int id){
    return schoolrepo.findById(id);
}

//GET ID

public schoolentity addSchoolentity(schoolentity schoolentity){
     return schoolrepo.save(schoolentity);
}

//UPDATE 
public void updateSchoolentity(schoolentity schoolentity , int id){
    schoolentity.setId(id);
    schoolrepo.save(schoolentity);

}

//DELETE ID
public void deleteById( int id){
    schoolrepo.deleteById(id);
}


}
