package com.example.forum.service.impl;

import com.example.forum.controller.ForumDTO;
import com.example.forum.entity.Forum;
import com.example.forum.repository.ForumRepository;
import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumServiceImpl(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    @Override
    public ForumDTO save(Long id, String author) {

        return null;
    }

    @Override
    public ForumDTO update(Long id, String author) {
<<<<<<< HEAD

=======
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
        return null;
    }

    @Override
<<<<<<< HEAD
    public Optional<Forum> findById(Long id) {

=======
    public Optional<Forum> findId(Long id) {
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
        return null;
    }
}
