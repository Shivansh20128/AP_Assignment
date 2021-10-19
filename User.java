package com.brickBracker;

public interface User {
    int id=0;
    void View_lectures();
    void View_assessments();
    void View_comments(Student x, Student y, Student z, Instructor a, Instructor b);
    void add_comments();
}
