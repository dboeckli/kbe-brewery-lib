package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import tools.jackson.databind.ObjectMapper;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerPagedListTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSerializeDeserializeWithPageRequest() {
        CustomerDto CustomerDto = createCustomerDto();

        CustomerPagedList pagedList = new CustomerPagedList(List.of(CustomerDto), PageRequest.of(1, 1), 1L);

        String json = objectMapper.writeValueAsString(pagedList);

        CustomerPagedList deserializedPagedList = objectMapper.readValue(json, CustomerPagedList.class);

        assertAll("CustomerPagedList Deserialization with PageRequest",
            () -> assertNotNull(deserializedPagedList),
            () -> assertEquals(1, deserializedPagedList.getContent().size()),
            () -> assertEquals(CustomerDto.getId(), deserializedPagedList.getContent().getFirst().getId())
        );
    }

    @Test
    void testSerializeDeserializeUnpaged() {
        CustomerDto CustomerDto = createCustomerDto();

        // Default constructor uses Unpaged internally if not modified
        CustomerPagedList pagedList = new CustomerPagedList(List.of(CustomerDto));

        String json = objectMapper.writeValueAsString(pagedList);

        CustomerPagedList deserializedPagedList = objectMapper.readValue(json, CustomerPagedList.class);

        assertAll("CustomerPagedList Deserialization Unpaged",
            () -> assertNotNull(deserializedPagedList),
            () -> assertEquals(1, deserializedPagedList.getContent().size()),
            () -> assertEquals(CustomerDto.getId(), deserializedPagedList.getContent().getFirst().getId())
        );
    }

    private CustomerDto createCustomerDto() {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .version(1L)
            .customerName("Customer Name")
            .createdDate(OffsetDateTime.now())
            .lastModifiedDate(OffsetDateTime.now())
            .build();
    }

}
