package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.List;

public interface AvatarService {
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    public Avatar findAvatar(Long studentId);



}
