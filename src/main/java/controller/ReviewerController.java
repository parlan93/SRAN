package controller;

import domain.ReviewRepository;
import domain.UserRepository;
import helper.ViewList;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/reviewer")
public class ReviewerController {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "")
    public String adminDashboard(Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.REVIEWER_DASHBOARD);
        model.addAttribute("data", reviewRepository.findByUser(userRepository.findByUserName(principal.getName())));
        return "reviewer-dashboard";
    }
    
}
