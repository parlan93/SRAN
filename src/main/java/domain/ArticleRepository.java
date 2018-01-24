package domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findBySender(User sender);
}
