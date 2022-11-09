package im.rubric.filmmakers.common.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Data
public class PageResponse<T> {
    @Builder.Default
    protected String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

    @Builder.Default
    protected HttpStatus status = HttpStatus.OK;

    @Builder.Default
    protected String message = "SUCCESS";

    public Collection<T> data;
    public long currentIndex;
    public long totalElement;
    public long currentPage;
    public long totalPage;

    public PageResponse(Page<T> data, Pageable page) {
        setData(data, page);
    }

    public <U> PageResponse(Page<U> map) {
    }

    public void setData(Page<T> data, Pageable page) {
        setData(data.getContent(), data.getNumber(), data.getTotalElements(), page);
    }

    public void setData(List<T> data, long currentIndex, long totalElements, Pageable page) {
        this.data = data;
        this.currentIndex = currentIndex;
        this.currentPage = page.getPageNumber();
        this.totalElement = totalElements;
        this.totalPage = totalElements / page.getPageSize();
        if (totalElements % page.getPageSize() > 0) totalPage++;
    }

}
