package com.rschir.db_admin.RestControllers;

import com.rschir.db_admin.Services.ProjectService;
import com.rschir.db_admin.Services.StatusService;
import com.rschir.db_admin.Services.TeamMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @Autowired
    ProjectService projectService;

    @Autowired
    StatusService statusService;

    @Autowired
    TeamMembersService teamMembersService;

    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("main_page");

        return modelAndView;
    }
}
