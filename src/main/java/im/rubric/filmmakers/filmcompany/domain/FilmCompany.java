package im.rubric.filmmakers.filmcompany.domain;


import im.rubric.filmmakers.common.exception.InvalidParamException;
import im.rubric.filmmakers.common.model.Address;
import im.rubric.filmmakers.film.domain.ActorRole;
import im.rubric.filmmakers.film.domain.Film;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "film_companies")
public class FilmCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Column(unique = true)
    private String companyCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filmCompany")
    private List<Film> films;

    public static FilmCompany create(String name, Address address, String companyCode) {
        FilmCompany company = new FilmCompany();
        company.name = name;
        company.address = address;
        company.companyCode = companyCode;
        return company;
    }

    public void update(String name, Address address) {
        this.name = name;
        this.address = address;
        validate();
    }

    public void validate() {
        validateName();
        validateAddress();
        validateCompanyCode();
    }

    private void validateCompanyCode() {
        if (companyCode == null || companyCode.isBlank())
            throw new InvalidParamException("Company Code can not be empty");
    }

    private void validateAddress() {
        if (address == null)
            throw new InvalidParamException("Company Address can not be null");
    }

    private void validateName() {
        if (name == null || name.isBlank())
            throw new InvalidParamException("Company Name can not be empty");
    }

}
