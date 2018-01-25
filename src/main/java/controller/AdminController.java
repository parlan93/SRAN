package controller;

import domain.ArticleRepository;
import domain.User;
import domain.UserRepository;
import domain.UserRolesRepository;
import helper.ViewList;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @RequestMapping(value = "")
    public String adminDashboard(Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_DASHBOARD);
        model.addAttribute("data", userRepository.findAll());
        model.addAttribute("dataArticle", articleRepository.findAll());
        Map<String, String> roles = new HashMap<String, String>();
        for (User user : userRepository.findAll()) {
            try {
                String userRoles = userRolesRepository.findRoleByUserName(user.getUserName()).toString();
                roles.put(user.getUserName(), userRoles);
            } catch (NullPointerException ex) {
            }
        }
        model.addAttribute("roles", roles);
        return "admin-dashboard";
    }

}
