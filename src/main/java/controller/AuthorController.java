package controller;

import domain.Article;
import domain.ArticleRepository;
import domain.enumerator.ArticleStatus;
import domain.ReviewRepository;
import domain.enumerator.ReviewStatus;
import domain.UserRepository;
import helper.FileReaderHelper;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    public String authorDashboard(
            @RequestParam(value = "save", required = false) String save,
            @RequestParam(value = "revise", required = false) String revise,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.AUTHOR_DASHBOARD);
        model.addAttribute("save", save);
        model.addAttribute("revise", revise);
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
    
    @RequestMapping(value = "/show/revised/{id}")
    public void showRevisedArticle(@PathVariable(value = "id") String articleId, HttpServletResponse response) throws FileNotFoundException, IOException {
        Article article = articleRepository.findOne(Long.valueOf(articleId));

        File file = new File(article.getRevisedFilePathWithNames());
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

    @RequestMapping(value = "/add-article")
    public String addArticleForm(
            @RequestParam(value = "error", required = false) String error,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.AUTHOR_ARTICLE_ADD);
        model.addAttribute("error", error);
        model.addAttribute("sender", userRepository.findByUserName(principal.getName()));
        return "author-article-add";
    }

    @RequestMapping(value = "/add-article/save", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public String saveNewArticle(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "authors") String authors,
            @RequestParam(value = "fileWithNames") MultipartFile fileWithNames,
            @RequestParam(value = "fileWithoutNames") MultipartFile fileWithoutNames,
            @RequestParam(value = "sender-id") String senderId,
            Model model, Principal principal) throws IOException {
        if (isTitleAvailable(title)) {
            if (!fileWithNames.isEmpty() && !fileWithoutNames.isEmpty()) {
                File withNames = FileReaderHelper.convert(fileWithNames);
                File withoutNames = FileReaderHelper.convert(fileWithoutNames);
                Article article = new Article(
                        title,
                        userRepository.findOne(Long.valueOf(senderId)),
                        authors,
                        withNames.getAbsolutePath(),
                        withoutNames.getAbsolutePath());
                articleRepository.save(article);
            } else {
                return "redirect:/add-article?error=1";
            }
        } else {
            return "redirect:/author/add-article?error=2";
        }
        return "redirect:/author?save=successed";
    }

    @RequestMapping(value = "/add-revised-article/{id}")
    public String addRevisedArticleForm(
            @PathVariable(value = "id") String articleId,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.AUTHOR_ARTICLE_REVISION);
        model.addAttribute("articleId", articleId);
        return "author-article-revision";
    }

    @RequestMapping(value = "/add-revised-article/save")
    public String saveRevisedArticle(
            @RequestParam(value = "fileWithNames") MultipartFile fileWithNames,
            @RequestParam(value = "fileWithoutNames") MultipartFile fileWithoutNames,
            @RequestParam(value = "article-id") String articleId,
            Model model, Principal principal
    ) throws IOException {
        if (!fileWithNames.isEmpty() && !fileWithoutNames.isEmpty()) {
            Article article = articleRepository.findOne(Long.valueOf(articleId));
            File withNames = FileReaderHelper.convertRevision(fileWithNames);
            File withoutNames = FileReaderHelper.convertRevision(fileWithoutNames);
            article.setRevisedFilePathWithNames(withNames.getAbsolutePath());
            article.setRevisedFilePathWithoutNames(withoutNames.getAbsolutePath());
            article.setArticleStatus(ArticleStatus.WAITING_FOR_REVIEW_ONCE_MORE);
            article.setReviewStatus(ReviewStatus.TO_REVIEW_ONCE_MORE);
            articleRepository.save(article);
        } else {
            return "redirect:/add-article?error=1";
        }
        return "redirect:/author?revise=successed";
    }

    private Boolean isTitleAvailable(String title) {
        for (Article article : articleRepository.findAll()) {
            if (article.getTitle().equalsIgnoreCase(title.trim())) {
                return false;
            }
        }
        return true;
    }

}
