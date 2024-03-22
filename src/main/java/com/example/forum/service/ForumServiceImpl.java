package com.example.forum.service;

import com.example.forum.controller.dto.SearchDTO;
import com.example.forum.entity.Page;
import com.example.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumServiceImpl(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    @Override
    public Page savePage(Page page) {
        return forumRepository.save(page);
    }

    @Override
    public Page getPage(Long id) {
        return forumRepository.findById(id);
    }

    @Override
    public List<Page> getPageList() {
        return forumRepository.findAll();
    }

    @Override
    public Page updatePage(Page page) {
        return forumRepository.update(page);
    }

    @Override
    public Long deletePage(Long id) {
        return forumRepository.deleteById(id);
    }

    @Override
    public List<Page> selectPageList(SearchDTO searchDTO) {
        return forumRepository.findByTitleOrAuthor(searchDTO);
    }
}
