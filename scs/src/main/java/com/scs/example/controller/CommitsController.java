package com.scs.example.controller;

import com.scs.example.model.Commit;
import com.scs.example.services.CommitsServices;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by cuixun on 4/20/16.
 * Controller
 */
@RestController
@EnableAutoConfiguration
public class CommitsController {

    private final String REPO = "rails/rails";


    //input the token here
    private String TOKEN = "****************************";

    CommitsServices commitsServices = new CommitsServices(REPO, TOKEN);


    /**
     * Return commits' json
     *
     * @return
     */
    @RequestMapping(value = "/get_commits", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Commit> commits() {
        List<Commit> list = null;

        list = commitsServices.getCommits();

        return list;
    }


    @RequestMapping(value = "/commits.html", method = RequestMethod.GET)
    public ModelAndView getCommits() {
        List<Commit> list = null;

        ModelMap model = new ModelMap();

        list = commitsServices.getCommits();
        model.addAttribute("commits", list);

        return new ModelAndView("commits", model);
    }


}
