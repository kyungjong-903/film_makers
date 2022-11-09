package im.rubric.filmmakers.filmcompany.presentation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import im.rubric.filmmakers.common.model.Address;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmCompanyDto {

    @Getter
    @Setter
    public static class Create {
        @NotEmpty
        private String name;
        @NotNull
        private Address address;
        @NotEmpty
        private String companyCode;
    }

    @Getter
    @Setter
    public static class Update {
        @NotEmpty
        private String name;
        @NotNull
        private Address address;
    }

    @Getter
    @Setter
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