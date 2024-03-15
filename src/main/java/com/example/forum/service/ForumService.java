package com.example.forum.service;

import com.example.forum.entity.Forum;
import com.example.forum.repository.ForumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public List<Forum> ForumList() {
        return forumRepository.findAll();
    }
}
