package ua.com.kture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.kture.model.Note;
import ua.com.kture.model.User;
import ua.com.kture.services.NotesService;
import ua.com.kture.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Note addNote(@RequestParam(name = "text") String text,
                 HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser;
        Note note = null;
        try {
            currentUser = userService.getUser(userDetails.getUsername());
            note = notesService.createNote(text, currentUser);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Can't create note");
        }
        return note;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    boolean removeNote(@RequestParam(name = "noteId") int noteId, HttpServletResponse response) throws IOException {
        boolean isRemoved = false;
        try {
            isRemoved = notesService.deleteNote(noteId);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Can't delete note");
        }
        return isRemoved;
    }
}
