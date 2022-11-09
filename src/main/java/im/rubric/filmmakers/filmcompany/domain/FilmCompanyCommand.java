package im.rubric.filmmakers.filmcompany.domain;

import im.rubric.filmmakers.common.model.Address;
import lombok.*;

public class FilmCompanyCommand {

    @Getter
    @Builder
    public static class Create {
        private final String name;
        private final Address address;
        private final String companyCode;
    }

    @Getter
    @Builder
    public static class Update {
        private final String name;
        private final Address address;
    }

}
