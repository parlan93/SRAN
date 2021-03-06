package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reviewid")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Article.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "articleid")
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userid")
    private User user;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = ReviewDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewDetailsId")
    private ReviewDetails reviewDetails;

    @Column(name = "description", length = 2047)
    private String description;

    public Review() {
    }

    public Review(Article article, User user, ReviewDetails reviewDetails, String description) {
        this.article = article;
        this.user = user;
        this.reviewDetails = reviewDetails;
        this.description = description;
    }

    public Review(Article article, User user) {
        this.article = article;
        this.user = user;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReviewDetails getReviewDetails() {
        return reviewDetails;
    }

    public void setReviewDetails(ReviewDetails reviewDetails) {
        this.reviewDetails = reviewDetails;
    }

}
