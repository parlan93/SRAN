package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "articleid")
    private Long articleId;

    @Column(name = "title", length = 2047)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender")
    private User sender;

    @Column(name = "authors", length = 2047)
    private String authors;

    @Column(name = "filePathWithNames")
    private String filePathWithNames;

    @Column(name = "filePathWithoutNames")
    private String filePathWithoutNames;

    @Enumerated
    @Column(name = "review_status")
    private ReviewStatus reviewStatus;

    @Enumerated
    @Column(name = "article_status")
    private ArticleStatus articleStatus;

    @Column(name = "revisedFilePathWithNames")
    private String revisedFilePathWithNames;

    @Column(name = "revisedFilePathWithoutNames")
    private String revisedFilePathWithoutNames;

    public Article() {
    }

    public Article(String title, User sender, String authors, String filePathWithNames, String filePathWithoutNames, ReviewStatus reviewStatus, ArticleStatus articleStatus) {
        this.title = title;
        this.sender = sender;
        this.authors = authors;
        this.filePathWithNames = filePathWithNames;
        this.filePathWithoutNames = filePathWithoutNames;
        this.reviewStatus = reviewStatus;
        this.articleStatus = articleStatus;
        this.revisedFilePathWithNames = "";
        this.revisedFilePathWithoutNames = "";
    }

    public Article(String title, User sender, String authors, String filePathWithNames, String filePathWithoutNames) {
        this.title = title;
        this.sender = sender;
        this.authors = authors;
        this.filePathWithNames = filePathWithNames;
        this.filePathWithoutNames = filePathWithoutNames;
        this.reviewStatus = ReviewStatus.TO_REVIEW;
        this.articleStatus = ArticleStatus.NEW;
        this.revisedFilePathWithNames = "";
        this.revisedFilePathWithoutNames = "";
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getFilePathWithNames() {
        return filePathWithNames;
    }

    public void setFilePathWithNames(String filePathWithNames) {
        this.filePathWithNames = filePathWithNames;
    }

    public String getFilePathWithoutNames() {
        return filePathWithoutNames;
    }

    public void setFilePathWithoutNames(String filePathWithoutNames) {
        this.filePathWithoutNames = filePathWithoutNames;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public ArticleStatus getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(ArticleStatus articleStatus) {
        this.articleStatus = articleStatus;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getRevisedFilePathWithNames() {
        return revisedFilePathWithNames;
    }

    public void setRevisedFilePathWithNames(String revisedFilePathWithNames) {
        this.revisedFilePathWithNames = revisedFilePathWithNames;
    }

    public String getRevisedFilePathWithoutNames() {
        return revisedFilePathWithoutNames;
    }

    public void setRevisedFilePathWithoutNames(String revisedFilePathWithoutNames) {
        this.revisedFilePathWithoutNames = revisedFilePathWithoutNames;
    }

}
