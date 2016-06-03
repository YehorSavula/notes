package ua.com.kture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.kture.model.User;
import ua.com.kture.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password, HttpServletResponse response) throws IOException {

        ModelAndView model = new ModelAndView();
        User user = null;
        try {
            user = userService.addUser(username, shaPasswordEncoder.encodePassword(password, null));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Can't register");
        }
        model.addObject(user);
        model.setViewName("homepage");
        return model;
    }
}
