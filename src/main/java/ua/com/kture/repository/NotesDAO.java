package ua.com.kture.repository;

import ua.com.kture.model.Note;

import java.util.List;

public interface NotesDAO {

    Note createNote(Note note) throws Exception;
    Note getNote(int noteId) throws Exception;
    List<Note> getUserNodes(int userId) throws Exception;
    boolean deleteNote(int noteId) throws Exception;
}
