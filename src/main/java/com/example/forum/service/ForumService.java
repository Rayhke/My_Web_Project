package com.example.forum.service;

import com.example.forum.controller.ForumDTO;
import com.example.forum.entity.Forum;

import java.util.Optional;

public interface ForumService {

    ForumDTO save(Long id, String author);

    ForumDTO update(Long id, String author);

<<<<<<< HEAD
    Optional<Forum> findById(Long id);
=======
    Optional<Forum> findId(Long id);
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
}
