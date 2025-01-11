package com.selfGroup.firstEmpCrud.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {


    @RequestMapping(value = "/")
    public String checkActiveProfile(){

        return "";
    }

}
