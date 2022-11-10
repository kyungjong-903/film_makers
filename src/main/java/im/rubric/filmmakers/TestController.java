package im.rubric.filmmakers;

import im.rubric.filmmakers.filmmaker.actor.infrastructure.ActorRepository;
import im.rubric.filmmakers.filmmaker.director.infrastructure.DirectorRepository;
import im.rubric.filmmakers.filmmaker.filmmaker.infrastructure.FilmMakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final FilmMakerRepository filmMakerRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;

    @GetMapping
    public void create() {

    }
}
