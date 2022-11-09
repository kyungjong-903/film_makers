package im.rubric.filmmakers.filmcompany.presentation;

import im.rubric.filmmakers.common.response.CommonResponse;
import im.rubric.filmmakers.common.response.PageResponse;
import im.rubric.filmmakers.filmcompany.application.FilmCompanyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film_company")
public class FilmCompanyController {

    private final FilmCompanyFacade filmCompanyFacade;
    private final FilmCompanyDtoMapper filmCompanyDtoMapper;

    @GetMapping
    public PageResponse<FilmCompanyDto.Main> page(
            FilmCompanyDto.Condition req,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var result = filmCompanyFacade.getFilmCompaniesPage(filmCompanyDtoMapper.of(req), pageable);
        var res = result.map(filmCompanyDtoMapper::of);
        return new PageResponse<>(res, pageable);
    }

    @GetMapping("/{id}")
    public CommonResponse<FilmCompanyDto.Detail> detail(
            @PathVariable Long id
    ) {
        var filmCompany = filmCompanyFacade.getFilmCompanyDetail(id);
        var res = filmCompanyDtoMapper.of(filmCompany);
        return CommonResponse.success(res);
    }

    @PostMapping
    public CommonResponse create(
            @RequestBody @Valid FilmCompanyDto.Create req
    ) {
        var create = filmCompanyDtoMapper.of(req);
        filmCompanyFacade.create(create);
        return CommonResponse.success();
    }

    @PutMapping("/{id}")
    public CommonResponse update(
            @PathVariable Long id,
            @RequestBody @Valid FilmCompanyDto.Update req
    ) {
        var update = filmCompanyDtoMapper.of(req);
        filmCompanyFacade.update(id, update);
        return CommonResponse.success();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
