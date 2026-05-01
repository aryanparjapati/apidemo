package com.restapi.apidemo.Databasecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.apidemo.helper.fileuploadhelper;

@RestController
public class FileuploadController {


    @Autowired
    private fileuploadhelper fileuploadhelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String>uploadFile(@RequestParam ("file") MultipartFile file){
    
     try{
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            
        }

        if (!file.getContentType().equals("image/jpeg")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file is allowed");
        }
        //FILE UPLOAD CODE
         boolean f = fileuploadhelper.uploadFile(file);
         if (f) {
           // return ResponseEntity.ok("file is uploaded successfully");

           //IMAGE UPLOADING TO DYNAMIC PATH
           return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
         }

     }catch(Exception e){
        e.printStackTrace();
     }
        return ResponseEntity.ok("working");
    }
    

    
}
