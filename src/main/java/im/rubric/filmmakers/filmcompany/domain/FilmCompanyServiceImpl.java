package im.rubric.filmmakers.filmcompany.domain;

import im.rubric.filmmakers.common.exception.EntityNotFoundException;
import im.rubric.filmmakers.common.exception.InvalidParamException;
import im.rubric.filmmakers.filmcompany.infrastructure.FilmCompanyRepository;
import im.rubric.filmmakers.filmcompany.presentation.FilmCompanyDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmCompanyServiceImpl implements FilmCompanyService {

    private final FilmCompanyRepository filmCompanyRepository;
    private final FilmCompanyInfoMapper filmCompanyInfoMapper;

    @Override
    @Transactional
    public void create(FilmCompanyCommand.Create req) {
        checkDuplicatedCompanyCode(req.getCompanyCode());
        FilmCompany company = FilmCompany.create(req.getName(), req.getAddress(), req.getCompanyCode());
        saveFilmCompany(company);
    }

    @Override
    @Transactional
    public void update(Long id, FilmCompanyCommand.Update req) {
        FilmCompany company = getCompanyById(id);
        company.update(req.getName(), req.getAddress());
    }

    @Override
    public Page<FilmCompanyQuery.Main> getFilmCompaniesByCondition(FilmCompanyQuery.Condition condition, Pageable pageable) {
        return filmCompanyRepository.findAllByCondition(condition, pageable);
    }

    @Override
    public FilmCompanyQuery.Detail getFilmCompanyById(Long id) {
        var company = getCompanyById(id);
        return filmCompanyInfoMapper.of(company, company.getFilms());
    }

    private FilmCompany getCompanyById(Long id) {
        return filmCompanyRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException("Not found Film Company"));
    }

    private void saveFilmCompany(FilmCompany company) {
        company.validate();
        filmCompanyRepository.save(company);
    }

    private void checkDuplicatedCompanyCode(String companyCode) {
        boolean exist = filmCompanyRepository.existsByCompanyCode(companyCode);
        if (exist) throw new InvalidParamException("duplicated company code");
    }
}
