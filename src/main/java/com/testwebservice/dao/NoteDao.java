package com.testwebservice.dao;

import com.testwebservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kosty on 03.06.2017.
 */
public interface NoteDao extends JpaRepository<Note, Long> {
    List<Note> findAllByOwner(String owner);
}
