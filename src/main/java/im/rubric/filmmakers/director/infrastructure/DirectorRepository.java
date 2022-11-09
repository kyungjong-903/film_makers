package im.rubric.filmmakers.director.infrastructure;

import im.rubric.filmmakers.director.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>, DirectorQueryDslRepository {
}
