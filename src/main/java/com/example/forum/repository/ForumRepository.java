package com.example.forum.repository;

import com.example.forum.entity.Forum;

import java.util.List;


public interface ForumRepository {

    List<Forum> findAll();
}