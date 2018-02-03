package domain;

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
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "review_details")
public class ReviewDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detailsId")
    private Long detailsId;

    @Enumerated
    @Column(name = "review_scope")
    private ReviewScope reviewScope;

    @Enumerated
    @Column(name = "review_content")
    private ReviewContent reviewContent;

    @Enumerated
    @Column(name = "review_conclusion_drawn")
    private ReviewConclusionDrawn reviewConclusionDrawn;

    @Enumerated
    @Column(name = "review_presentation")
    private ReviewPresentation reviewPresentation;

    @Enumerated
    @Column(name = "review_language")
    private ReviewLanguage reviewLanguage;

    @Enumerated
    @Column(name = "review_abstract")
    private ReviewAbstract reviewAbstract;

    @Enumerated
    @Column(name = "review_illustrations")
    private ReviewIllustrations reviewIllustrations;

    @Enumerated
    @Column(name = "review_tables")
    private ReviewTables reviewTables;

    @Enumerated
    @Column(name = "review_afu")
    private ReviewAFU reviewAFU;

    @Enumerated
    @Column(name = "review_literature_references")
    private ReviewLiteratureReferences reviewLiteratureReferences;

    @Enumerated
    @Column(name = "review_overall_evaluation")
    private ReviewOverallEvaluation reviewOverallEvaluation;

    @Enumerated
    @Column(name = "review_final_recommendation")
    private ReviewFinalRecommendation reviewFinalRecommendation;

    protected ReviewDetails() {
    }

    public ReviewDetails(ReviewScope reviewScope, ReviewContent reviewContent, ReviewConclusionDrawn reviewConclusionDrawn, ReviewPresentation reviewPresentation, ReviewLanguage reviewLanguage, ReviewAbstract reviewAbstract, ReviewIllustrations reviewIllustrations, ReviewTables reviewTables, ReviewAFU reviewAFU, ReviewLiteratureReferences reviewLiteratureReferences, ReviewOverallEvaluation reviewOverallEvaluation, ReviewFinalRecommendation reviewFinalRecommendation) {
        this.reviewScope = reviewScope;
        this.reviewContent = reviewContent;
        this.reviewConclusionDrawn = reviewConclusionDrawn;
        this.reviewPresentation = reviewPresentation;
        this.reviewLanguage = reviewLanguage;
        this.reviewAbstract = reviewAbstract;
        this.reviewIllustrations = reviewIllustrations;
        this.reviewTables = reviewTables;
        this.reviewAFU = reviewAFU;
        this.reviewLiteratureReferences = reviewLiteratureReferences;
        this.reviewOverallEvaluation = reviewOverallEvaluation;
        this.reviewFinalRecommendation = reviewFinalRecommendation;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public ReviewScope getReviewScope() {
        return reviewScope;
    }

    public void setReviewScope(ReviewScope reviewScope) {
        this.reviewScope = reviewScope;
    }

    public ReviewContent getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(ReviewContent reviewContent) {
        this.reviewContent = reviewContent;
    }

    public ReviewConclusionDrawn getReviewConclusionDrawn() {
        return reviewConclusionDrawn;
    }

    public void setReviewConclusionDrawn(ReviewConclusionDrawn reviewConclusionDrawn) {
        this.reviewConclusionDrawn = reviewConclusionDrawn;
    }

    public ReviewPresentation getReviewPresentation() {
        return reviewPresentation;
    }

    public void setReviewPresentation(ReviewPresentation reviewPresentation) {
        this.reviewPresentation = reviewPresentation;
    }

    public ReviewLanguage getReviewLanguage() {
        return reviewLanguage;
    }

    public void setReviewLanguage(ReviewLanguage reviewLanguage) {
        this.reviewLanguage = reviewLanguage;
    }

    public ReviewAbstract getReviewAbstract() {
        return reviewAbstract;
    }

    public void setReviewAbstract(ReviewAbstract reviewAbstract) {
        this.reviewAbstract = reviewAbstract;
    }

    public ReviewIllustrations getReviewIllustrations() {
        return reviewIllustrations;
    }

    public void setReviewIllustrations(ReviewIllustrations reviewIllustrations) {
        this.reviewIllustrations = reviewIllustrations;
    }

    public ReviewTables getReviewTables() {
        return reviewTables;
    }

    public void setReviewTables(ReviewTables reviewTables) {
        this.reviewTables = reviewTables;
    }

    public ReviewAFU getReviewAFU() {
        return reviewAFU;
    }

    public void setReviewAFU(ReviewAFU reviewAFU) {
        this.reviewAFU = reviewAFU;
    }

    public ReviewLiteratureReferences getReviewLiteratureReferences() {
        return reviewLiteratureReferences;
    }

    public void setReviewLiteratureReferences(ReviewLiteratureReferences reviewLiteratureReferences) {
        this.reviewLiteratureReferences = reviewLiteratureReferences;
    }

    public ReviewOverallEvaluation getReviewOverallEvaluation() {
        return reviewOverallEvaluation;
    }

    public void setReviewOverallEvaluation(ReviewOverallEvaluation reviewOverallEvaluation) {
        this.reviewOverallEvaluation = reviewOverallEvaluation;
    }

    public ReviewFinalRecommendation getReviewFinalRecommendation() {
        return reviewFinalRecommendation;
    }

    public void setReviewFinalRecommendation(ReviewFinalRecommendation reviewFinalRecommendation) {
        this.reviewFinalRecommendation = reviewFinalRecommendation;
    }

}
