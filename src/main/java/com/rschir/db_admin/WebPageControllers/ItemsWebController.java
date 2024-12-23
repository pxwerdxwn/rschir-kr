package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsWebController {

    private final ItemRepository itemRepository;

    public ItemsWebController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public ModelAndView itemsPage() {
        ModelAndView modelAndView = new ModelAndView("items");

        return modelAndView;
    }
}
