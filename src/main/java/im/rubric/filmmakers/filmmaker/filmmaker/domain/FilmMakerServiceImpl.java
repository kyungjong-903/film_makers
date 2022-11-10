package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import im.rubric.filmmakers.common.exception.EntityNotFoundException;
import im.rubric.filmmakers.common.exception.InvalidParamException;
import im.rubric.filmmakers.filmmaker.filmmaker.infrastructure.FilmMakerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmMakerServiceImpl implements FilmMakerService {

    private final FilmMakerRepository filmMakerRepository;
    private final FilmMakerInfoMapper filmMakerInfoMapper;

    @Override
    @Transactional
    public void create(FilmMakerCommand.Create req) {
        checkDuplicatedMakerCodeCode(req.getFilmMakerCode());
        FilmMaker filmMaker = FilmMaker.create(req.getFilmMakerCode(), req.getName(), req.getGender(), req.getBirth(), req.getNationality());
        saveFilmMaker(filmMaker);
    }

    @Override
    @Transactional
    public void update(Long id, FilmMakerCommand.Update req) {
        FilmMaker filmMaker = getMakerById(id);
        filmMaker.update(req.getName(), req.getBirth(), req.getGender(), req.getNationality());
        saveFilmMaker(filmMaker);
    }

    @Override
    public Page<FilmMakerInfo.Main> getFilmMakersByCondition(FilmMakerInfo.Condition condition, Pageable pageable) {
        return filmMakerRepository.getFilmMakersByCondition(condition, pageable);
    }

    @Override
    public FilmMakerInfo.Detail getFilmMakerById(Long id) {
        var filmMaker = getMakerById(id);
        return new FilmMakerInfo.Detail(filmMaker);
    }

    private FilmMaker getMakerById(Long id) {
        return filmMakerRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException("Not found Film Maker"));
    }

    private void saveFilmMaker(FilmMaker maker) {
        maker.validate();
        filmMakerRepository.save(maker);
    }

    private void checkDuplicatedMakerCodeCode(String filmMakerCode) {
        boolean exist = filmMakerRepository.existsByFilmMakerCode(filmMakerCode);
        if (exist) throw new InvalidParamException("duplicated company code");
    }

}
