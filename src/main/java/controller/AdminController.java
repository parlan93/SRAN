package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @RequestMapping(value = "")
    public String adminDashboard(Model model) {
        model.addAttribute("pageTitle", "Panel Administracyjny");
        return "admin-dashboard";
    }
    
}
