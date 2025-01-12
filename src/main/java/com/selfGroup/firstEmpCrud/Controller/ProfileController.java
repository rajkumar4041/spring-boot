package com.selfGroup.firstEmpCrud.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${output.message}")
    private  String msg;

    @RequestMapping(value = "/")
    public String checkActiveProfile(){

        return msg;
    }

}
