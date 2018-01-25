package controller;

import domain.Article;
import domain.ArticleRepository;
import domain.ReviewRepository;
import domain.UserRepository;
import helper.ViewList;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pdf.ReviewToPdf;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    private static final Logger LOG = Logger.getLogger(AuthorController.class.getName());

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(value = "")
    public String authorDashboard(Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.AUTHOR_DASHBOARD);
        model.addAttribute("data", articleRepository.findBySender(userRepository.findByUserName(principal.getName())));
        return "author-dashboard";
    }

    @RequestMapping(value = "/details/{id}")
    public String detailsArticle(
            @PathVariable(value = "id") String articleId,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.AUTHOR_ARTICLE_DETAILS);
        model.addAttribute("article", articleRepository.findOne(Long.valueOf(articleId)));
        model.addAttribute("reviews", reviewRepository.findByArticle(articleRepository.findOne(Long.valueOf(articleId))));
        return "author-article-details";
    }

    @RequestMapping(value = "/show/{id}")
    public void showArticle(@PathVariable(value = "id") String articleId, HttpServletResponse response) throws FileNotFoundException, IOException {
        Article article = articleRepository.findOne(Long.valueOf(articleId));

        File file = new File(article.getFilePathWithNames());
        if (!file.exists()) {
            LOG.log(Level.INFO, "File not found");
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            LOG.log(Level.INFO, "mimeType not detectable");
            mimeType = "application/octet-stream";
        }
        LOG.log(Level.INFO, "MimeType: {0}", mimeType);

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @RequestMapping(value = "/details/review/{reviewId}")
    public ModelAndView reviewToPdf(
            @PathVariable(value = "reviewId") String reviewId,
            @RequestParam(value = "articleId") String articleId) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("article", articleRepository.findOne(Long.valueOf(articleId)));
        model.put("review", reviewRepository.findOne(Long.valueOf(reviewId)));
        return new ModelAndView(new ReviewToPdf(), model);
    }

}
