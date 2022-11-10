package im.rubric.filmmakers.filmmaker.director.infrastructure;

import im.rubric.filmmakers.filmmaker.director.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>, DirectorQueryDslRepository {
}
