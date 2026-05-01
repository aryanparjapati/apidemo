package com.restapi.apidemo.Databasecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.apidemo.Database.schoolentity;
import com.restapi.apidemo.Databaseservices.servi;

@RestController
public class controller {

    @Autowired
    private servi servi;

    //GET ALL
    @GetMapping("/school")
    public ResponseEntity<List<schoolentity>> getAllschoolentity() {
        List<schoolentity>list = servi.getAllSchoolentities();
        if (list.size()==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        return ResponseEntity.of(Optional.of(list));
    }

    //GET BY ID
    @GetMapping("school/{id}")
    public ResponseEntity<schoolentity>getschoolentityById(@PathVariable int id){
     schoolentity schoolentity = servi.getSchoolentityById(id);
     if (schoolentity== null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
     return ResponseEntity.of(Optional.of(schoolentity));
    }
    

    //POST MAPPING 
@PostMapping("/school")
public ResponseEntity<schoolentity>addschoolEntity(@RequestBody schoolentity schoolentity){
    schoolentity schoolentity2 = servi.addSchoolentity(schoolentity);
    if (schoolentity == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }
    return ResponseEntity.of(Optional.of(schoolentity));
}


//DELEET MAPPING 
@DeleteMapping("school/{id}")
public ResponseEntity<Void> deleteById(@PathVariable int id) {

    servi.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}

// UPDATE MAPPING
@PutMapping("/school/{id}")
public ResponseEntity<schoolentity> updateSchool(@RequestBody schoolentity schoolentity, @PathVariable int id) {
    
    schoolentity.setId(id);
    schoolentity updated = servi.addSchoolentity(schoolentity); // save/update

    return ResponseEntity.ok(updated);
}

}
