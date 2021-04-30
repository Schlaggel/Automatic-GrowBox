package com.example.webApp.controller;

import com.example.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping()
    public String userList(Model model,
      @PageableDefault(sort = {"userId"}) Pageable pageable) {

        long count = userService.count();
        boolean hasPrev = pageable.getPageNumber() > 0;
        boolean hasNext = (pageable.next().getPageNumber() * pageable.next().getPageSize()) < count  ;
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageable.getPageNumber() - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("user", userService.findAll(pageable));
        model.addAttribute("next", pageable.getPageNumber() + 1);

        System.out.print(userService.findAll(pageable));
        return "admin";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/search")
    public String searchUser(@RequestParam String username, Model model,@PageableDefault Pageable pageable) throws Exception {

        if(!username.isEmpty()) {
            model.addAttribute("user", userService.findByUsername(username));
        }else{

            model.addAttribute("user", userService.findAll(pageable));
            long count = userService.count();
            boolean hasPrev = pageable.getPageNumber() > 0;
            boolean hasNext = (pageable.next().getPageNumber() * pageable.next().getPageSize()) < count  ;
            model.addAttribute("hasPrev", hasPrev);
            model.addAttribute("prev", pageable.getPageNumber() - 1);
            model.addAttribute("hasNext", hasNext);
            model.addAttribute("user", userService.findAll(pageable));
            model.addAttribute("next", pageable.getPageNumber() + 1);
        }
        return "admin";
    }
}