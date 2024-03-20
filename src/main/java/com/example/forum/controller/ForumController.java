package com.example.forum.controller;

import com.example.forum.entity.Page;
import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/")
    public String forum(Model model) {
        List<Page> result = getPageList();
        if (result.isEmpty()) {
            model.addAttribute("error", "게시글이 존재하지 않습니다.");
        } else {
            model.addAttribute("forumPageList", result);
        }
        return "forum";
    }

    @GetMapping("/page/write")
    public String write() {
        return "page/write";
    }

    /**
     * @return 삽입
     */
    @PostMapping("/page/write")
    public String save(PageDTO pageDTO) {
        Page page = pageDTO.Join();
        savePage(page);
        return "redirect:/forum/";
        // return "redirect:/forum/page/read?id=" + forumDTO.getId();
    }

    /**
     * @return 조회
     */
    @GetMapping("/page/read") // <a th:href="@{/forum/read(id=${forumPage.id})}">
    public String read(@RequestParam("id") Long id, Model model) {
        Page result = getPage(id);
        if (result.allNotNull()) {
            model.addAttribute("error", "페이지가 존재하지 않습니다.");
        } else {
            model.addAttribute("forumPage", result);
        }
        return "page/read";
    }

    /**
     * @return 수정
     */
    @GetMapping("/page/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Page result = getPage(id);
        if (result.allNotNull()) {
            model.addAttribute("error", "페이지가 존재하지 않습니다.");
        } else {
            model.addAttribute("forumPage", result);
        }
        return "page/update";
    }

    @PostMapping("/page/update")
    public String update(PageDTO pageDTO) {
        Page result = pageDTO.Join();
        updatePage(result);
        return "redirect:/forum/";
    }

    /**
     * @return 삭제
     */
    @GetMapping("/page/delete")
    public String delete(@RequestParam("id") Long id) {
        deletePage(id);
        return "redirect:/forum/";
    }

    /**
     * @return 검색
     */
    @GetMapping("/page/select")
    public String select(@RequestParam(name = "mode", required = false) String mode, @RequestParam(name = "contents", required = false) String content, Model model) {
        ForumSearchDTO searchDTO = new ForumSearchDTO(mode, content);
        List<Page> result = selectPageList(searchDTO);
        if (result.isEmpty()) {
            model.addAttribute("error", "조건에 부합하는 게시글이 존재하지 않습니다.");
        } else {
            model.addAttribute("forumPageList", result);
        }
        return "forum";
    }
    /*@GetMapping("/search")
    public String select(@RequestParam("mode") String mode, @RequestParam("contents") String contents) {
        return "redirect:/forum/";
    }*/

    /*@GetMapping("/{id}") // th:href="@{'/forum/' + ${forumPage.id}}"
    public String read(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "page/read";
    }*/

    // 삽입
    public Page savePage(Page page) {
        return forumService.savePage(page);
    }

    // 조회
    public Page getPage(Long id) {
        return forumService.getPage(id);
    }

    // 전체 조회
    public List<Page> getPageList() {
        return forumService.getPageList();
    }

    // 수정
    public Page updatePage(Page page) {
        return forumService.updatePage(page);
    }
    
    // 삭제
    public Long deletePage(Long id) {
        return forumService.deletePage(id);
    }

    // 검색
    public List<Page> selectPageList(ForumSearchDTO searchDTO) {
        return forumService.selectPageList(searchDTO);
    }
}
