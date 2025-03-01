package com.selfGroup.firstEmpCrud;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//@Component - to give info that we may need to autowired this component class
// & we may need to autoConfigure in future
@Component
public class FileUploadHelper {

    //    public final String FILE_DIRECTORY = "/assets/uploadedFiles/";
//    public final String FILE_DIRECTORY = "/home/ttpl-lnv-0255/Desktop/spring-boot/firstEmpCrud/src/main/assets/uploadedFiles/";
    //dynamic path
    public final String FILE_DIRECTORY = new ClassPathResource("/assets/uploadedFiles/").getFile().getAbsolutePath() + "/";

    public FileUploadHelper() throws IOException {
    }


    public ResponseEntity<String> validateUploadFile(MultipartFile file) throws IOException {

        File directory = new File(FILE_DIRECTORY);

//        created Folder to store uploaded filepath
        if (!directory.exists()) {
            directory.mkdirs();
        }


        // Create file path
        Path filePath = Paths.get(FILE_DIRECTORY + file.getOriginalFilename());

        // Save file (overwrite if exists)
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        //alternative for above copy method of file
//         Files.write(filePath, file.getBytes());


//        response with path
//        return ResponseEntity.ok("SuccessFully Uploaded File");
//                                                                   if path then website-path/...
//           ServletUriComponentsBuilder.fromCurrentContextPath() -> localHost://9000/<path>/<filename>
        return ResponseEntity.ok(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/uploadedFiles/")
                        .path(file.getOriginalFilename())
                        .toUriString()
        );

//        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploadedFiles/").path(file.getOriginalFilename()).toUriString());

    }

}
