package im.rubric.filmmakers.film.domain;


import javax.persistence.*;

@Entity(name = "director_roles")
public class DirectorRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DirectorRole director;

    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;
}
