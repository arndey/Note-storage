/*
 * Copyright (C) 2017 The Open Source Project
 */

package com.testwebservice.dao;

import com.testwebservice.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Dao for {@link com.testwebservice.model.Note}
 */
public interface NoteDao extends JpaRepository<Note, Long> {
    List<Note> findAllByOwner(String owner);
}
