package kalemyazilim.fileapp.fileorganizer.controller;

import kalemyazilim.fileapp.fileorganizer.model.UserModel;
import kalemyazilim.fileapp.fileorganizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;
    //Constructor based injection.
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
