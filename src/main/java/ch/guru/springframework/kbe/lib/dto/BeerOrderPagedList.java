/*
 *  Copyright 2019 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.guru.springframework.kbe.lib.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tools.jackson.databind.JsonNode;

import java.util.List;

public class BeerOrderPagedList extends PageImpl<BeerOrderDto> {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerOrderPagedList(@JsonProperty("content") List<BeerOrderDto> content,
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

    public BeerOrderPagedList(List<BeerOrderDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerOrderPagedList(List<BeerOrderDto> content) {
        super(content, PageRequest.of(0, content.isEmpty() ? 1 : content.size()), content.size());
    }
}
