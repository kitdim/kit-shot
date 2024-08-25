package kit.org.app.repository;

import kit.org.app.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    @Query("SELECT l FROM Link l where l.user.id=?1")
    List<Link> findAllByUserId(Long userId);
}
