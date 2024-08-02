package com.techlabs.app.service;

import com.techlabs.app.entity.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(int id);

    Instructor addInstructor(Instructor instructor);

    void deleteInstructor(Instructor instructor);

    Instructor assignInstructor(int id, int cid);

    Instructor deassignInstructor(int id, int cid);
}
