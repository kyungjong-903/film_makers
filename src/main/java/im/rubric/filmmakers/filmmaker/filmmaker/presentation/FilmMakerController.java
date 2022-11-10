package im.rubric.filmmakers.filmmaker.filmmaker.presentation;

import im.rubric.filmmakers.common.response.CommonResponse;
import im.rubric.filmmakers.common.response.PageResponse;
import im.rubric.filmmakers.filmmaker.filmmaker.application.FilmMakerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film_maker")
public class FilmMakerController {

    private final FilmMakerFacade filmMakerFacade;
    private final FilmMakerDtoMapper filmMakerDtoMapper;

    @GetMapping
    public PageResponse<FilmMakerDto.Main> page(
            FilmMakerDto.Condition req,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var result = filmMakerFacade.getFilmMakersPage(filmMakerDtoMapper.of(req), pageable);
        var res = result.map(filmMakerDtoMapper::of);
        return new PageResponse<>(res, pageable);
    }

    @GetMapping("/{id}")
    public CommonResponse<FilmMakerDto.Detail> detail(
            @PathVariable Long id
    ) {
        var filmMaker = filmMakerFacade.getFilmMakerDetail(id);
        var res = new FilmMakerDto.Detail(filmMaker);
        return CommonResponse.success(res);
    }

    @PostMapping
    public CommonResponse create(
            @RequestBody @Valid FilmMakerDto.Create req
    ) {
        var create = filmMakerDtoMapper.of(req);
        filmMakerFacade.create(create);
        return CommonResponse.success();
    }

    @PutMapping("/{id}")
    public CommonResponse update(
            @PathVariable Long id,
            @RequestBody @Valid FilmMakerDto.Update req
    ) {
        var update = filmMakerDtoMapper.of(req);
        filmMakerFacade.update(id, update);
        return CommonResponse.success();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
