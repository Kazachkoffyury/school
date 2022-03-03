package ru.hogwarts.school.service;



import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    public Faculty createFaculty(Faculty faculty);
    public Faculty findFaculty(int id);
    public Faculty updateFaculty(Faculty faculty);
    public void deleteFaculty(int id);
    public Collection<Faculty> getAll();
    public Collection<Faculty> findByColor(String color);
    public Collection<Faculty> findByColorOrName(String color,String name);
}
