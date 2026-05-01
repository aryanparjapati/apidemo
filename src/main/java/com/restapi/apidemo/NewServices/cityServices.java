package com.restapi.apidemo.NewServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.apidemo.NewEntity.cityentity;

@Component
public class cityServices {
     private List<cityentity> list = new ArrayList<>();

     public cityServices(){
        list.add(new cityentity(12, "Aryan Prajapati", "Shivpuram lane no 10 "));
        list.add(new cityentity(13, "Harsh Prajapati ", "Gurgaon sector 49 near shiv mandir "));
        list.add(new cityentity(14, "Anshul Prajaoati", "Modinagar india "));
     }

     //GET ALL
     public List<cityentity>getAllCityentities(){
        return list;
     }

     //GET BY ID
      public cityentity getCityById(int id){
        return list.stream().filter(e->e.getId()==id).findFirst().orElse(null);
      }

      //ADD BOOK
      public cityentity addCityentity(cityentity cityentity){
        list.add(cityentity);
        return cityentity;
      }

      // DELETE A DATA
      public void deleteById(int id){
        list = list.stream().filter(cityentity-> cityentity.getId()!=id).collect(Collectors.toList());
      }
      
      // UPDATE A DATA
       public cityentity updateCityentity(cityentity cityentity, int id) {
           list = list.stream().map(b -> {
           if (b.getId() == id) {
            b.setName(cityentity.getName());
            b.setAddress(cityentity.getAddress());
            }
             return b;
            }).collect(Collectors.toList());

             return cityentity;
}
}
