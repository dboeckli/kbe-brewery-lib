package ch.guru.springframework.kbe.lib.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tools.jackson.databind.JsonNode;

import java.util.List;


public class CustomerPagedList extends PageImpl<CustomerDto> {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CustomerPagedList(@JsonProperty("content") List<CustomerDto> content,
                             @JsonProperty("number") Integer number,
                             @JsonProperty("size") Integer size,
                             @JsonProperty("totalElements") Long totalElements,
                             @JsonProperty("pageable") JsonNode pageable,
                             @JsonProperty("last") Boolean last,
                             @JsonProperty("totalPages") Integer totalPages,
                             @JsonProperty("sort") JsonNode sort,
                             @JsonProperty("first") Boolean first,
                             @JsonProperty("numberOfElements") Integer numberOfElements) {

        super(content,
            PageRequest.of(number != null ? number : 0, size != null ? size : 25),
            totalElements != null ? totalElements : 0L);
    }

    public CustomerPagedList(List<CustomerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CustomerPagedList(List<CustomerDto> content) {
        super(content);
    }
}
