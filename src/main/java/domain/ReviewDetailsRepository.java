package domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
public interface ReviewDetailsRepository extends JpaRepository<ReviewDetails, Long>{
    
}
