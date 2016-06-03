package ua.com.kture.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.kture.model.Note;
import ua.com.kture.model.User;
import ua.com.kture.repository.NotesDAO;
import ua.com.kture.services.NotesService;

import java.util.Date;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDAO notesDAO;

    @Override
    public Note createNote(String text, User user) throws Exception {
        Note note = new Note();
        note.setText(text);
        note.setCreatedDate(new Date(System.currentTimeMillis()));
        note.setUser(user);
        return notesDAO.createNote(note);
    }

    @Override
    public Note updateNote(int noteId, String text) throws Exception {
        Note note = notesDAO.getNote(noteId);
        note.setText(text);
        return notesDAO.updateNote(note);
    }

    @Override
    public List<Note> getUserNodes(int userId) throws Exception {
        return notesDAO.getUserNodes(userId);
    }

    @Override
    public boolean deleteNote(int noteId) throws Exception {
        return notesDAO.deleteNote(noteId);
    }
}
