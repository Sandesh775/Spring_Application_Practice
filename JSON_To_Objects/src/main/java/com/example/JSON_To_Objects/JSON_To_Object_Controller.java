package com.example.JSON_To_Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSON_To_Object_Controller {
    @PostMapping("/enroll")
    public String enrollEndpoint(@RequestBody Enrollment enroll){
        return enroll.getStudent().getName()+" enrolled in "+enroll.getCourse().getTitle()+" for "+enroll.getCourse().getDuration()+" days";
    }
}
