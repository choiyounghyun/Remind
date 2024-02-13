package com.example.remind.contoller;

import com.example.remind.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @GetMapping("/test")
    public UserDto hi() {
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("ALEX");
        return userDto;
    }
}
