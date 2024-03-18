package com.example.forum.service;

import com.example.forum.controller.ForumSearchDTO;
import com.example.forum.entity.Page;
import com.example.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Page savePage(Page page) {
        return forumRepository.save(page);
    }

    public Page getPage(Long id) {
        return forumRepository.findById(id);
    }

    public List<Page> getPageList() {
        return forumRepository.findAll();
    }

    public Page updatePage(Page page) {
        return forumRepository.update(page);
    }

    public Long deletePage(Long id) {
        return forumRepository.deleteById(id);
    }

    public List<Page> selectPageList(ForumSearchDTO searchDTO) {
        return forumRepository.findByTitleOrAuthor(searchDTO);
    }

    /*public List<Forum> searchList(ForumSearchDTO searchDTO) {
        return forumRepository.findByValue(searchDTO);
    }*/
}
