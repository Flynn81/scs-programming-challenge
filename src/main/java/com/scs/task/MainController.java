package com.scs.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class MainController {

    private final String REPO = "rails/rails";

    @RequestMapping("/*")
    public String index(Model model) {

        GitCommits commits = new GitCommits(REPO);
        try {
            model.addAttribute("commitsList", commits.getCommits());
        } catch (IOException e) {
            System.out.println("Error getting commits!");
        }
        return "index";
    }

}

