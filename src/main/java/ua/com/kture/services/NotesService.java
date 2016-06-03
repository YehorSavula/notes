package ua.com.kture.services;

import ua.com.kture.model.Note;
import ua.com.kture.model.User;

import java.util.List;

public interface NotesService {

    Note createNote(String text, User user) throws Exception;
    Note updateNote(int noteId, String text) throws Exception;
    List<Note> getUserNodes(int userId) throws Exception;
    boolean deleteNote(int noteId) throws Exception;
}