package security;

import domain.Article;
import domain.ArticleRepository;
import domain.ArticleStatus;
import domain.Review;
import domain.ReviewRepository;
import domain.ReviewStatus;
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
        User u1 = new User("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), "admin@admin.admin", "Admin", "Admin", 1, "Dr", "UTP");
        User u2 = new User("author", BCrypt.hashpw("author", BCrypt.gensalt()), "author@author.author", "Author", "Author", 1, "Dr inż.", "UTP");
        User u3 = new User("reviewer", BCrypt.hashpw("reviewer", BCrypt.gensalt()), "rewiever@reviever.reviewer", "Reviewer", "Reviewer", 1, "Dr hab. inż.", "UKW");
        User u4 = new User("reviewer2", BCrypt.hashpw("reviewer2", BCrypt.gensalt()), "rewiever2@reviever.reviewer", "Reviewer2", "Reviewer2", 1, "Dr hab. inż.", "UKW");
        userRepository.save(Arrays.asList(u1, u2, u3, u4));

        UserRole ur1 = new UserRole(u1.getUserid(), "ADMIN");
        UserRole ur2 = new UserRole(u2.getUserid(), "AUTHOR");
        UserRole ur3 = new UserRole(u3.getUserid(), "REVIEWER");
        UserRole ur4 = new UserRole(u4.getUserid(), "REVIEWER");
        userRolesRepository.save(Arrays.asList(ur1, ur2, ur3, ur4));

        Article a1 = new Article("Artykuł 1", u2, "Kubuś Puchatek", "G:/DATA/PSS/art-1-z.pdf", "G:/DATA/PSS/art-1-bez.pdf", ReviewStatus.TO_REVIEW, ArticleStatus.NEW);
        Article a2 = new Article("Artykuł 2", u2, "Kubuś Puchatek, Tygrysek", "none", "none", ReviewStatus.TO_REVIEW, ArticleStatus.NEW);
        articleRepository.save(Arrays.asList(a1, a2));

        Review r1 = new Review(a1, u3, ReviewStatus.POSITIVE, "hahaha");
        Review r2 = new Review(a2, u3, ReviewStatus.TO_REVIEW_ONCE_MORE, "XDXD");
        Review r3 = new Review(a2, u4, ReviewStatus.NEGATIVE, "Lol");
        reviewRepository.save(Arrays.asList(r1, r2, r3));
    }
    
}
