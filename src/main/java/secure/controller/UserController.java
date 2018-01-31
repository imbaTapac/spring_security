package secure.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import secure.entity.User;
import secure.service.SecurityService;
import secure.service.UserService;
import secure.validator.UserValidator;



@Controller
@ComponentScan("secure")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute ("userForm") User user,BindingResult bindingResult,Model model) {

       userValidator.validate(user,bindingResult);
      if (bindingResult.hasErrors()) {
           return "registration";
       }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error,String logout,String message) {

        if (error != null) {
            model.addAttribute("error", "Пароль или имя пользователя неправильные");
        }

        if (logout != null) {
            model.addAttribute("message", "Успешный выход");
        }

        return "login";
    }



    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
