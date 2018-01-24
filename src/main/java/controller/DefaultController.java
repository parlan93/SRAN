package controller;

import helper.ViewList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
public class DefaultController {

    @RequestMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("currentPage", ViewList.HOME);
        return "home";
    }

    // TODO: Do usunięcia
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Logowanie");
        return "login";
    }
    
    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "Rejestracja");
        return "register";
    }

    @RequestMapping(value = "/403")
    public String error403(Model model) {
        model.addAttribute("pageTitle", "Błąd - brak uprawnień");
        return "403";
    }

    @RequestMapping(value = "/404")
    public String error404(Model model) {
        model.addAttribute("pageTitle", "Błąd - strony nie odnaleziono");
        return "403";
    }

    @RequestMapping(value = "/table-sample")
    public String tableSample(Model model) {
        model.addAttribute("pageTitle", "Tabela");
        return "table-sample";
    }

}
