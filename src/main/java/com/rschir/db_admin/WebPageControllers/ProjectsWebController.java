package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectsWebController {

    private final ProjectRepository projectRepository;

    public ProjectsWebController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public ModelAndView projectsPage() {
        ModelAndView modelAndView = new ModelAndView("projects");

        return modelAndView;
    }
}
