package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskWebController {

    private final TaskRepository taskRepository;

    public TaskWebController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public ModelAndView tasksPage() {
        ModelAndView modelAndView = new ModelAndView("tasks");
        modelAndView.addObject("tasks", taskRepository.findAll());
        return modelAndView;
    }
}
