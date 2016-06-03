package ua.com.kture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.kture.model.Note;
import ua.com.kture.services.NotesService;
import ua.com.kture.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private NotesService notesService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/homepage", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void getNotes(HttpServletResponse response, Principal principal, Model model) throws IOException {
        List<Note> notes = null;
        try {
            notes = notesService.getUserNodes(userService.getUser(principal.getName()).getUserId());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Can't get notes");
        }
        model.addAttribute(notes);
    }
}
