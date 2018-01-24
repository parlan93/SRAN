package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/author")
public class AuthorController {
    
    @RequestMapping(value = "")
    public String adminDashboard(Model model) {
        model.addAttribute("pageTitle", "Panel Autora");
        return "author-dashboard";
    }
    
}
