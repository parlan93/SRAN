package controller;

import domain.Article;
import domain.ArticleRepository;
import domain.Review;
import domain.ReviewDetails;
import domain.ReviewRepository;
import domain.enumerator.ReviewStatus;
import domain.UserRepository;
import domain.enumerator.ReviewAFU;
import domain.enumerator.ReviewAbstract;
import domain.enumerator.ReviewConclusionDrawn;
import domain.enumerator.ReviewContent;
import domain.enumerator.ReviewFinalRecommendation;
import domain.enumerator.ReviewIllustrations;
import domain.enumerator.ReviewLanguage;
import domain.enumerator.ReviewLiteratureReferences;
import domain.enumerator.ReviewOverallEvaluation;
import domain.enumerator.ReviewPresentation;
import domain.enumerator.ReviewScope;
import domain.enumerator.ReviewTables;
import helper.ViewList;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.security.Principal;
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

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping(value = "/reviewer")
public class ReviewerController {

    private static final Logger LOG = Logger.getLogger(ReviewerController.class.getName());

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;
    
    @RequestMapping(value = "")
    public String reviewerDashboard(
            @RequestParam(value = "success", required = false) String success,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.REVIEWER_DASHBOARD);
        model.addAttribute("data", reviewRepository.findByUser(userRepository.findByUserName(principal.getName())));
        if (success != null) {
            if (success.equals("saved")) {
                model.addAttribute("success", "success");
            }
        }
        return "reviewer-dashboard";
    }

    @RequestMapping(value = "/review/{id}")
    public String reviewForm(
            @PathVariable(value = "id") Long id,
            Model model, Principal principal) {
        model.addAttribute("currentPage", ViewList.REVIEWER_REVIEW_FORM);
        model.addAttribute("article", articleRepository.findOne(id));
        return "reviewer-review-form";
    }

    @RequestMapping(value = "/review/save", method = RequestMethod.POST)
    public String saveReview(
            @RequestParam(value = "review-scope", required = true) String reviewScope,
            @RequestParam(value = "review-content", required = true) String reviewContent,
            @RequestParam(value = "review-conclusion-drawn", required = true) String reviewConclusionDrawn,
            @RequestParam(value = "review-presentation", required = true) String reviewPresentation,
            @RequestParam(value = "review-language", required = true) String reviewLanguage,
            @RequestParam(value = "review-abstract", required = true) String reviewAbstract,
            @RequestParam(value = "review-illustrations", required = true) String reviewIllustrations,
            @RequestParam(value = "review-tables", required = true) String reviewTables,
            @RequestParam(value = "review-afu", required = true) String reviewAFU,
            @RequestParam(value = "review-literature-references", required = true) String reviewLiteratureReferences,
            @RequestParam(value = "review-overall-evaluation", required = true) String reviewOverallEvaluation,
            @RequestParam(value = "review-final-recommendation", required = true) String reviewFinalRecommendation,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "article-id") String articleId,
            Model model, Principal principal) {
        ReviewDetails reviewDetails = new ReviewDetails(
                ReviewScope.valueOf(reviewScope), ReviewContent.valueOf(reviewContent), 
                ReviewConclusionDrawn.valueOf(reviewConclusionDrawn), ReviewPresentation.valueOf(reviewPresentation), 
                ReviewLanguage.valueOf(reviewLanguage), ReviewAbstract.valueOf(reviewAbstract), 
                ReviewIllustrations.valueOf(reviewIllustrations), ReviewTables.valueOf(reviewTables), 
                ReviewAFU.valueOf(reviewAFU), ReviewLiteratureReferences.valueOf(reviewLiteratureReferences), 
                ReviewOverallEvaluation.valueOf(reviewOverallEvaluation), ReviewFinalRecommendation.valueOf(reviewFinalRecommendation));
        Review review = reviewRepository.findByUserAndArticle(
                userRepository.findByUserName(principal.getName()),
                articleRepository.findOne(Long.valueOf(articleId)));
        review.setDescription(description);
        review.setReviewDetails(reviewDetails);
        reviewRepository.save(review);
        return "redirect:/reviewer?success=saved";
    }

    @RequestMapping(value = "/show/{id}")
    public void showArticle(@PathVariable(value = "id") String articleId, HttpServletResponse response) throws FileNotFoundException, IOException {
        Article article = articleRepository.findOne(Long.valueOf(articleId));

        File file = new File(article.getFilePathWithoutNames());
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

        File file = new File(article.getRevisedFilePathWithoutNames());
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
}
