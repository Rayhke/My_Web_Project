package com.example.forum.service;

import com.example.forum.controller.dto.SearchDTO;
import com.example.forum.entity.Page;

import java.util.List;

public interface ForumService {

    Page savePage(Page page);

    Page getPage(Long id);

    List<Page> getPageList();

    Page updatePage(Page page);

    Long deletePage(Long id);

    List<Page> selectPageList(SearchDTO searchDTO);
}
