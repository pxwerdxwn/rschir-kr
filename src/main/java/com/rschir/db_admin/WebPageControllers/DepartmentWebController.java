package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentWebController {

    private final DepartmentRepository departmentRepository;

    public DepartmentWebController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public ModelAndView departmentsPage() {
        ModelAndView modelAndView = new ModelAndView("departments");
        modelAndView.addObject("departments", departmentRepository.findAll());
        return modelAndView;
    }
}
