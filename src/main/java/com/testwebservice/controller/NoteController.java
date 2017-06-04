/*
 * Copyright (C) 2017 The Open Source Project
 */

package com.testwebservice.controller;

import com.testwebservice.dao.NoteDao;
import com.testwebservice.model.Note;

import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {
    @Autowired
    private NoteDao noteDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "start";
    }

    @RequestMapping(value = "/add-note", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("note", new Note());

        return "add-note";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Note note) {
        if (note.getName() == null || note.getOwner() == null) {
            return "redirect:/add-note";
        } else {
            this.noteDao.save(note);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results() {
        return "results";
    }

    @ResponseBody
    @RequestMapping(value = "/get-results/{owner}", method = RequestMethod.GET)
    public String getJson(@PathVariable(name = "owner") String owner) {
        JSONArray jsonArray = new JSONArray(this.noteDao.findAllByOwner(owner));
        String result = jsonArray.toString();

        return result.equals("") ? null : result;
    }
}