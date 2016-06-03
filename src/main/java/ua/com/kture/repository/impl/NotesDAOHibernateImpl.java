package ua.com.kture.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import ua.com.kture.model.Note;
import ua.com.kture.repository.BaseDAO;
import ua.com.kture.repository.NotesDAO;

import java.util.List;

public class NotesDAOHibernateImpl extends BaseDAO implements NotesDAO {

    @Override
    public Note createNote(Note note) throws Exception {
        try {
            begin();
            getSession().save(note);
            commit();
            return note;
        } catch (HibernateException e) {
            throw new Exception("Can't save note", e);
        }
    }

    @Override
    public Note updateNote(Note note) throws Exception {
        try {
            begin();
            getSession().update(note);
            commit();
            return note;
        } catch (HibernateException e) {
            throw new Exception("Can't update note", e);
        }
    }

    @Override
    public Note getNote(int noteId) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Note where noteId = :noteId");
            q.setInteger("noteId", noteId);
            Note note = (Note) q.list().get(0);
            commit();
            return note;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get note for noteId: " + noteId, e);
        }
    }

    @Override
    public List<Note> getUserNodes(int userId) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Note where User.userId = :userId");
            q.setInteger("userId", userId);
            List<Note> notes = q.list();
            commit();
            return notes;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get notes for user: " + userId, e);
        }
    }

    @Override
    public boolean deleteNote(int noteId) throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("delete Note where noteId = :noteId");
            query.setParameter("noteId", noteId);
            int result = query.executeUpdate();
            commit();
            return result > 0;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete note: " + noteId, e);
        }
    }
}
