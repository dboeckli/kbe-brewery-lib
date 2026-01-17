package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import tools.jackson.databind.ObjectMapper;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerOrderPagedListTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSerializeDeserializeWithPageRequest() {
        BeerOrderDto BeerOrderDto = createBeerOrderDto();

        BeerOrderPagedList pagedList = new BeerOrderPagedList(List.of(BeerOrderDto), PageRequest.of(1, 1), 1L);

        String json = objectMapper.writeValueAsString(pagedList);

        BeerOrderPagedList deserializedPagedList = objectMapper.readValue(json, BeerOrderPagedList.class);

        assertAll("BeerOrderPagedList Deserialization with PageRequest",
            () -> assertNotNull(deserializedPagedList),
            () -> assertEquals(1, deserializedPagedList.getContent().size()),
            () -> assertEquals(BeerOrderDto.getId(), deserializedPagedList.getContent().getFirst().getId())
        );
    }

    @Test
    void testSerializeDeserializeUnpaged()  {
        BeerOrderDto BeerOrderDto = createBeerOrderDto();

        // Default constructor uses Unpaged internally if not modified
        BeerOrderPagedList pagedList = new BeerOrderPagedList(List.of(BeerOrderDto));

        String json = objectMapper.writeValueAsString(pagedList);

        BeerOrderPagedList deserializedPagedList = objectMapper.readValue(json, BeerOrderPagedList.class);

        assertAll("BeerOrderPagedList Deserialization Unpaged",
            () -> assertNotNull(deserializedPagedList),
            () -> assertEquals(1, deserializedPagedList.getContent().size()),
            () -> assertEquals(BeerOrderDto.getId(), deserializedPagedList.getContent().getFirst().getId())
        );
    }

    private BeerOrderDto createBeerOrderDto() {
        return BeerOrderDto.builder()
            .id(UUID.randomUUID())
            .version(1)
            .createdDate(OffsetDateTime.now())
            .lastModifiedDate(OffsetDateTime.now())
            .customerId(UUID.randomUUID())
            .customerRef("Test Ref")
            .beerOrderLines(List.of())
            .orderStatus("NEW")
            .orderStatusCallbackUrl("http://example.com/callback")
            .build();
    }

}
