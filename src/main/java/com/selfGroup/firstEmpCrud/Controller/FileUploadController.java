package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload/file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//        System.out.println(file.getOriginalFilename());

        if (file.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain File");

//        else if (!"image".contains(Objects.requireNonNull(file.getContentType())))
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Image is allowed to Upload");


//      getInputStream  throws IOException

        try {

            return fileUploadHelper.validateUploadFile(file);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SomeThing Went Wrong , please try again after sometime");

        }

    }

}

