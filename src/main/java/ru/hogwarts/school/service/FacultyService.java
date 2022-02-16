package ru.hogwarts.school.service;



import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    public Faculty createFaculty(Faculty faculty);
    public Faculty findFaculty(int id);
    public Faculty updateFaculty(Faculty faculty);
    public Faculty deleteFaculty(int id);
    public Collection<Faculty> getAll();
    public Collection<Faculty> getFacultiesWithColor(String color);
}
