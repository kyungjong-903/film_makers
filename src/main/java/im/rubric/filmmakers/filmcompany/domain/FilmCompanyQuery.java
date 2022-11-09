package im.rubric.filmmakers.filmcompany.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import im.rubric.filmmakers.common.model.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class FilmCompanyQuery {

    @Getter
    @Builder
    public static class Condition {
        private String keyword;
        private String companyCode;

    }

    @Getter
    @Builder
    public static class Main {
        private Long id;
        private String name;
    }

    @Getter
    @Builder
    public static class Detail {
        private Long id;
        private String name;
        private Address address;
        private String companyCode;
        private List<Film> films;
    }

    @Getter
    @Builder
    public static class Film {
        private Long id;
        private String title;
    }

}
