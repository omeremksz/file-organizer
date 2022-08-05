package kalemyazilim.fileapp.fileorganizer.controller;

import kalemyazilim.fileapp.fileorganizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class UserController {
    @Autowired
    private final UserService userService;
    //Constructor based injection.
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void loginUser(String userName, String userPassword){
        userService.loginUser(userName,userPassword);
    }
}
