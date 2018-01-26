package controller;

import domain.Article;
import domain.ArticleRepository;
import domain.ArticleStatus;
import domain.Review;
import domain.ReviewRepository;
import domain.ReviewStatus;
import domain.User;
import domain.UserRepository;
import domain.UserRole;
import domain.UserRolesRepository;
import helper.ViewList;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static final Logger LOG = Logger.getLogger(AdminController.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(value = "")
    public String adminDashboard(
            @RequestParam(value = "enabled", required = false) String enabled,
            @RequestParam(value = "disabled", required = false) String disabled,
            @RequestParam(value = "role", required = false) String role,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_DASHBOARD);
        model.addAttribute("enabled", enabled);
        model.addAttribute("disabled", disabled);
        model.addAttribute("role", role);
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

    @RequestMapping(value = "/users/show/{id}")
    public String userDetails(
            @PathVariable(value = "id") String userId,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_USER_DETAILS);
        model.addAttribute("user", userRepository.findOne(Long.valueOf(userId)));

        try {
            UserRole userRole = userRolesRepository.findByUserid(Long.valueOf(userId));
            model.addAttribute("role", userRole.getRole());
            LOG.log(Level.INFO, "USER ROLE: {0}", userRole.getRole());

            switch (userRole.getRole()) {
                case "AUTHOR":
                    LOG.log(Level.INFO, "USER ROLE: author block");
                    model.addAttribute("data", articleRepository.findBySender(userRepository.findOne(Long.valueOf(userId))));
                    break;
                case "REVIEWER":
                    LOG.log(Level.INFO, "USER ROLE: reviewer block");
                    List<Review> reviews = reviewRepository.findByUser(userRepository.findOne(Long.valueOf(userId)));
                    List<Article> articles = new ArrayList<>();
                    for (Review review : reviews) {
                        articles.add(review.getArticle());
                    }
                    model.addAttribute("data", articles);
                    break;
                default:
                    break;
            }

        } catch (NullPointerException ex) {
            model.addAttribute("role", "none");
            LOG.log(Level.INFO, "USER ROLE: not found");
        }

        return "admin-user-details";
    }

    @RequestMapping(value = "/users/activate/{id}")
    public String activateUser(
            @PathVariable(value = "id") String userId,
            Model model, Principal principal) {
        User user = userRepository.findOne(Long.valueOf(userId));
        user.setEnabled(1);
        userRepository.save(user);
        return "redirect:/admin?enabled=successed";
    }

    @RequestMapping(value = "/users/deactivate/{id}")
    public String deactivateUser(
            @PathVariable(value = "id") String userId,
            Model model, Principal principal) {
        User user = userRepository.findOne(Long.valueOf(userId));
        user.setEnabled(0);
        userRepository.save(user);
        return "redirect:/admin?disabled=successed";
    }

    @RequestMapping(value = "/users/role/{id}")
    public String changeUserRole(
            @PathVariable(value = "id") String userId,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_USER_ROLE);
        model.addAttribute("role", userRolesRepository.findRoleByUserName(userRepository.findOne(Long.valueOf(userId)).getUserName()));
        model.addAttribute("userId", userId);
        return "admin-user-role";
    }

    @RequestMapping(value = "/users/role/save", method = RequestMethod.POST)
    public String saveUserRole(
            @RequestParam(value = "role") String role,
            @RequestParam(value = "userId") String userId,
            Model model, Principal principal) {
        User user = userRepository.findOne(Long.valueOf(userId));
        try {
            UserRole userRole = userRolesRepository.findByUserid(user.getUserid());
            switch (role) {
                case "NONE":
                    userRolesRepository.delete(userRole);
                    break;
                case "AUTHOR":
                    userRole.setRole("AUTHOR");
                    userRolesRepository.save(userRole);
                    break;
                case "REVIEWER":
                    userRole.setRole("REVIEWER");
                    userRolesRepository.save(userRole);
                    break;
                case "ADMIN":
                    userRole.setRole("ADMIN");
                    userRolesRepository.save(userRole);
                    break;
            }
        } catch (NullPointerException ex) {
            switch (role) {
                case "NONE":
                    break;
                case "AUTHOR":
                    userRolesRepository.save(new UserRole(Long.valueOf(userId), "AUTHOR"));
                    break;
                case "REVIEWER":
                    userRolesRepository.save(new UserRole(Long.valueOf(userId), "REVIEWER"));
                    break;
                case "ADMIN":
                    userRolesRepository.save(new UserRole(Long.valueOf(userId), "ADMIN"));
                    break;
            }
        }
        return "redirect:/admin?role=successed";
    }

    @RequestMapping(value = "/articles/show/{id}")
    public String articleDetails(
            @PathVariable(value = "id") String articleId,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_ARTICLE_DETAILS);
        model.addAttribute("article", articleRepository.findOne(Long.valueOf(articleId)));
        model.addAttribute("reviews", reviewRepository.findByArticle(articleRepository.findOne(Long.valueOf(articleId))));
        return "admin-article-details";
    }

    @RequestMapping(value = "/articles/reviewers/{id}")
    public String articleReviewers(
            @PathVariable(value = "id") String articleId,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_ARTICLE_REVIEWERS);
        model.addAttribute("success", success);
        model.addAttribute("error", error);

        Article article = articleRepository.findOne(Long.valueOf(articleId));
        model.addAttribute("article", article);
        model.addAttribute("articleId", article.getArticleId());

        List<User> users = userRepository.findAll();
        List<User> reviewers = new ArrayList<>();
        for (User user : users) {
            try {
                UserRole userRole = userRolesRepository.findByUserid(user.getUserid());
                if (userRole.getRole().equalsIgnoreCase("REVIEWER")) {
                    reviewers.add(user);
                }
            } catch (NullPointerException ex) {
            }
        }
        model.addAttribute("reviewers", reviewers);

        List<Review> reviews = new ArrayList<>();
        try {
            reviews = reviewRepository.findByArticle(article);
            switch (reviews.size()) {
                case 2:
                    model.addAttribute("first", reviews.get(0).getUser());
                    model.addAttribute("second", reviews.get(1).getUser());
                    break;
                case 3:
                    model.addAttribute("first", reviews.get(0).getUser());
                    model.addAttribute("second", reviews.get(1).getUser());
                    model.addAttribute("third", reviews.get(2).getUser());
                    break;
            }
            model.addAttribute("reviewersAmount", reviews.size());
        } catch (NullPointerException ex) {
            model.addAttribute("reviewersAmount", 0);
        }

        return "admin-article-reviewers";
    }

    @RequestMapping(value = "/articles/reviewers/save")
    public String saveReviewers(
            @RequestParam(value = "reviewer-1") String firstId,
            @RequestParam(value = "reviewer-2") String secondId,
            @RequestParam(value = "reviewer-3", required = false) String thirdId,
            @RequestParam(value = "article-id") String articleId,
            Model model, Principal principal) {
        Article article = articleRepository.findOne(Long.valueOf(articleId));
        List<Review> reviews = new ArrayList<>();
        try {
            reviews = reviewRepository.findByArticle(articleRepository.findOne(Long.valueOf(articleId)));
        } catch (NullPointerException ex) {
        }

        if (reviews.size() == 3) {
            return "redirect:/admin/articles/reviewers/" + articleId + "?error=1";
        } else {
            if (thirdId == null) {
                if (!firstId.equals(secondId)) {
                    if (reviews.size() != 2) {
                        reviewRepository.save(Arrays.asList(
                                new Review(article, userRepository.findOne(Long.valueOf(firstId)), ReviewStatus.TO_REVIEW),
                                new Review(article, userRepository.findOne(Long.valueOf(secondId)), ReviewStatus.TO_REVIEW)
                        ));
                        article.setReviewStatus(ReviewStatus.TO_REVIEW);
                        article.setArticleStatus(ArticleStatus.WAITING_FOR_REVIEW);
                        articleRepository.save(article);
                        return "redirect:/admin/articles/reviewers/" + articleId + "?success=1";
                    } else {
                        return "redirect:/admin/articles/reviewers/" + articleId + "?error=2";
                    }
                } else {
                    return "redirect:/admin/articles/reviewers/" + articleId + "?error=3";
                }
            } else {
                if (!firstId.equals(secondId) && !firstId.equals(thirdId) && !secondId.equals(thirdId)) {
                    reviewRepository.save(new Review(article, userRepository.findOne(Long.valueOf(thirdId)), ReviewStatus.TO_REVIEW));
                    article.setReviewStatus(ReviewStatus.TO_REVIEW);
                    article.setArticleStatus(ArticleStatus.WAITING_FOR_REVIEW);
                    articleRepository.save(article);
                    return "redirect:/admin/articles/reviewers/" + articleId + "?success=2";
                } else {
                    return "redirect:/admin/articles/reviewers/" + articleId + "?error=3";
                }
            }
        }
    }

    @RequestMapping(value = "/articles/edit/{id}")
    public String editArticle(
            @PathVariable(value = "id") String articleId,
            @RequestParam(value = "success", required = false) String success,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.ADMIN_ARTICLE_EDIT);
        model.addAttribute("article", articleRepository.findOne(Long.valueOf(articleId)));
        model.addAttribute("success", success);
        return "admin-article-edit";
    }

    @RequestMapping(value = "/articles/edit/save")
    public String saveArticle(
            @RequestParam(value = "article-id") String articleId,
            @RequestParam(value = "review-status", required = false) String reviewStatus,
            @RequestParam(value = "article-status", required = false) String articleStatus,
            Model model, Principal principal) {
        Article article = articleRepository.findOne(Long.valueOf(articleId));
        ReviewStatus reviewStatusEnum = ReviewStatus.valueOf(reviewStatus);
        ArticleStatus articleStatusEnum = ArticleStatus.valueOf(articleStatus);
        article.setReviewStatus(reviewStatusEnum);
        article.setArticleStatus(articleStatusEnum);
        articleRepository.save(article);
        return "redirect:/admin/articles/edit/" + articleId + "?success=1";
    }

}
