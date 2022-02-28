package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.stream.Collectors;
@Service

public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(int id) {
        return facultyRepository.getById(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(int id) {

         facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getAll() {

        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> findByColor(String color) {
        return  facultyRepository.findByColor(color);

    }

    @Override
    public Collection<Faculty> findByColorOrName(String color, String name) {
        return facultyRepository.findByColorIgnoreCaseOrNameIgnoreCase(color,name);
    }
}
