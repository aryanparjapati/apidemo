package com.restapi.apidemo.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadhelper {

    //    public final String UPLOAD_DIR =
    //   "C:\\Users\\ARYAN\\OneDrive\\Desktop\\RestAPIs\\apidemo\\src\\main\\resources\\static";

    // IMAGE UPLOADING TO DYNAMIC PATH 
    public final String UPLOAD_DIR =
        System.getProperty("user.dir") +
        "\\apidemo\\src\\main\\resources\\static\\image";


       public boolean uploadFile(MultipartFile file) {
        boolean f = false;

        try {
            
            Files.copy(
                    file.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING
            );

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}