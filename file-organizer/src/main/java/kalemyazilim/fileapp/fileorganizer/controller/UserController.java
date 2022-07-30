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

    /*Get user login page method.*/
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login request: "+ userModel);
        UserModel loggedInUser = userService.loginUser(userModel.getUserName(),userModel.getUserPassword());
        if(loggedInUser != null){
            model.addAttribute("userLogin",loggedInUser.getUserName());
            return "personal_page";//TODO: list the user's files.
        }
        else{
            return "error_page";
        }
    }

}
