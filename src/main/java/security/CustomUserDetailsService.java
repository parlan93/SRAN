package security;

import domain.Article;
import domain.ArticleRepository;
import domain.enumerator.ArticleStatus;
import domain.Review;
import domain.ReviewDetails;
import domain.ReviewRepository;
import domain.enumerator.ReviewStatus;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import domain.User;
import domain.UserRepository;
import domain.UserRole;
import domain.UserRolesRepository;
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
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;
    private final ArticleRepository articleRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository, ArticleRepository articleRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.articleRepository = articleRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user, userRoles);
        }
    }

    @PostConstruct
    public void init() {
        deleteAll();
        sampleData();
    }

    private void deleteAll() {
        reviewRepository.deleteAll();
        articleRepository.deleteAll();
        userRepository.deleteAll();
        userRolesRepository.deleteAll();
    }

    private void sampleData() {
        User u1 = new User("FredrickPatterson", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "Fredrick.Patterson@iu.us", "Fredrick", "Patterson", 1, "Dr inż.", "Independence University");
        User u2 = new User("WilsonHuber", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "Wilson.Huber@hi.uk", "Wilson", "Huber", 1, "Dr", "Hawking Institute");
        User u3 = new User("EdnaGalloway", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "EdnaGalloway@lou.us", "Edna", "Galloway", 1, "Dr hab.", "Lone Oak University");
        User u4 = new User("YolandaFrancis", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "Yolanda.Francis@rvi.us", "Yolanda", "Francis", 0, "Prof. dr hab.", "River Valley Institute");
        User u5 = new User("LeonardSanford", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "Leonard.Sanford@hu.uk", "Leonard", "Sanford", 1, "Prof. dr hab. inż.", "Horizon University");
        User u6 = new User("Admin", BCrypt.hashpw("zaq1@WSX", BCrypt.gensalt()), "admin@admin.pl", "Administrator", "", 1, "", "");
        userRepository.save(Arrays.asList(u1, u2, u3, u4, u5, u6));

        UserRole ur1 = new UserRole(u1.getUserid(), "REVIEWER");
        UserRole ur2 = new UserRole(u2.getUserid(), "REVIEWER");
        UserRole ur3 = new UserRole(u3.getUserid(), "AUTHOR");
        UserRole ur5 = new UserRole(u5.getUserid(), "REVIEWER");
        UserRole ur6 = new UserRole(u6.getUserid(), "ADMIN");
        userRolesRepository.save(Arrays.asList(ur1, ur2, ur3, ur5, ur6));

        Article a1 = new Article("Paragon of Hell - Sir of the Future", u3,
                "Edna Galloway, Owen Thomson, Nikolas O'connor, Max Spencer, Ruggero Di Nunzio",
                "G:/DATA/PSS/article-1-z.pdf", "G:/DATA/PSS/article-1-bez.pdf",
                ReviewStatus.TO_REVIEW, ArticleStatus.NEW);
        Article a2 = new Article("Cardinal of Justice - Monk of the Stars", u3,
                "Edna Galloway, Bogumił Bartosiewicz",
                "G:/DATA/PSS/article-2-z.pdf", "G:/DATA/PSS/article-2-bez.pdf",
                ReviewStatus.TO_REVIEW_ONCE_MORE, ArticleStatus.REVIEWED_TO_CORRECT);
        Article a3 = new Article("Lord of Water - Prime of Natural Resources", u3,
                "Edna Galloway",
                "G:/DATA/PSS/article-3-z.pdf", "G:/DATA/PSS/article-3-bez.pdf",
                ReviewStatus.AMBIGUOUS, ArticleStatus.WAITING_FOR_REVIEW);
        articleRepository.save(Arrays.asList(a1, a2, a3));

        Review r1 = new Review(a2, u1, 
                new ReviewDetails(
                        ReviewScope.VERY_SPECIALISED, ReviewContent.NEW_TECHNIQUE_OR_THEORY, 
                        ReviewConclusionDrawn.ADEQUATE, ReviewPresentation.TOO_COMPREHENSIVE_SHOULD_BE_SHORTENED, 
                        ReviewLanguage.NEEDS_CORRECTIONS, ReviewAbstract.CLEAR_AND_ADEQUATE, 
                        ReviewIllustrations.NON_VERY_INFORMATIVE, ReviewTables.ADEQUATE, 
                        ReviewAFU.SHOULD_BE_EXPLAINED, ReviewLiteratureReferences.INADEQUATE, 
                        ReviewOverallEvaluation.EXCELLENT, ReviewFinalRecommendation.ACCEPT_WITH_NO_CHANGES),
                "Their wide mouths and almost hidden noses often make these aliens appear to be cautious, but looks can be deceiving. Their ears are small and stubby and their hearing is fairly good. They also have two small horns on their elbows.");
        Review r2 = new Review(a2, u2, 
                new ReviewDetails(
                        ReviewScope.RELEVANT_TO_THE_FIELD_OF_DSP, ReviewContent.NEW_APPLICATION_OF_KNOWN_CONCEPTS, 
                        ReviewConclusionDrawn.NOT_JUSTIFIED, ReviewPresentation.TOO_BRIEF_FOR_CLARITY, 
                        ReviewLanguage.SATISFACTORY, ReviewAbstract.SHOULD_BE_REWRITTEN, 
                        ReviewIllustrations.MOORE_SHOULD_BE_ADDED, ReviewTables.SOME_MAY_BE_OMITTED, 
                        ReviewAFU.SHOULD_BE_CHANGED, ReviewLiteratureReferences.ADEQUATE, 
                        ReviewOverallEvaluation.GOOD, ReviewFinalRecommendation.REJECT),
                "The strange man claims the man will have to leave town within 2 hours or risk being stuck in a quarantine zone. There will be traffic jams and other hindrances, so it's best to leave right now without taking anything with you. Suspicious of this situation, but somewhat trusting of this strange man, the man somewhat hesitantly agrees to the proposal, this whole situation is both exciting and terrifying at the same time, but surely the right choice was made.");
        Review r3 = new Review(a3, u5, 
                new ReviewDetails(
                        ReviewScope.OF_GENERAL_RELEVANCE, ReviewContent.TOO_PRELIMINARY, 
                        ReviewConclusionDrawn.SUFFER_FROM_LOOSE_GENERALISATIONS, ReviewPresentation.GENERAL_ORGANISATION_UNSUITABLE, 
                        ReviewLanguage.NEEDS_SUBSTANTIAL_REVISION_OR_REWRITING, ReviewAbstract.CLEAR_AND_ADEQUATE, 
                        ReviewIllustrations.ADEQUATE, ReviewTables.SHOULD_BE_REARRANGED_TO_IMPROVE_CLARITY, 
                        ReviewAFU.CONFORM_TO_ACCEPTED_FORM, ReviewLiteratureReferences.MORE_SHOULD_BE_ADDED, 
                        ReviewOverallEvaluation.SOUND_BUT_DULL, ReviewFinalRecommendation.REVISE_AND_RESUBMIT),
                "When the time comes that the darkness rises once more, the lost one shall bring forth a world of darkness.");
        Review r4 = new Review(a3, u1, 
                new ReviewDetails(
                        ReviewScope.OUT_OF_SCOPE, ReviewContent.TOO_TECHNICAL, 
                        ReviewConclusionDrawn.SUFFER_FROM_SUBSTANTIAL_OMISSIONS, ReviewPresentation.ADEQUATE, 
                        ReviewLanguage.SATISFACTORY, ReviewAbstract.SHOULD_BE_REWRITTEN, 
                        ReviewIllustrations.NON_VERY_INFORMATIVE, ReviewTables.ADEQUATE, 
                        ReviewAFU.CONFORM_TO_ACCEPTED_FORM, ReviewLiteratureReferences.SOME_MAY_BE_OMITTED, 
                        ReviewOverallEvaluation.WITHOUT_OBVIOUS_SIGNIFICANCE, ReviewFinalRecommendation.ACCEPT_WITH_NO_CHANGES),
                "Upon the day the sun turns dark, a man clad in green shall bring forth an age of justice and an age of magic.");
        reviewRepository.save(Arrays.asList(r1, r2, r3, r4));
    }

}
