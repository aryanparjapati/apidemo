package com.restapi.apidemo.newcontroller;

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

import com.restapi.apidemo.NewEntity.cityentity;
import com.restapi.apidemo.NewServices.cityServices;

@RestController
public class CityController {

    @Autowired
    private cityServices cityServices;


    //GET ALL BOOKS
    @GetMapping("/test")
    public ResponseEntity<List<cityentity>>getAllcityEntity(){
        List<cityentity>list = cityServices.getAllCityentities();
        if (list.size()==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();            
        }
        return ResponseEntity.of(Optional.of(list));
    }

    //GET BOOK BY ID
    @GetMapping("test/{id}")
    public ResponseEntity<cityentity>getCityById(@PathVariable int id){
        cityentity cityentity = cityServices.getCityById(id);
        if (cityentity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        return ResponseEntity.of(Optional.of(cityentity));
    }

    // POST MAPPING - Add Data
@PostMapping("/test")
public ResponseEntity<cityentity> addCityEntity(@RequestBody cityentity cityentity) {
cityentity cityentity1 = cityServices.addCityentity(cityentity);

    if (cityentity == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
     return ResponseEntity.status(HttpStatus.CREATED).body(cityentity1);
  }



  //DELETE MAPPING - TO DELETE A DATA 
  @DeleteMapping("test/{id}")
  public ResponseEntity<Void>deleteById(@PathVariable int id){
    cityServices.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  //PUT MAPPING - TO UPDATE A DATA

 // UPDATE CITY
@PutMapping("test/{id}")
public ResponseEntity<cityentity> updateCity(
        @RequestBody cityentity cityentity,
        @PathVariable int id) {

    cityentity updatedCity = cityServices.updateCityentity(cityentity, id);

    if (updatedCity == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.ok(updatedCity);
}
}




    
