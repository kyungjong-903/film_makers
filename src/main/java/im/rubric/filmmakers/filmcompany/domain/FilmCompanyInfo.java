package im.rubric.filmmakers.filmcompany.domain;

import im.rubric.filmmakers.common.model.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class FilmCompanyInfo {

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
        private List<?> films;

    }

}
