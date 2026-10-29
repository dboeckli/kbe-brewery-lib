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
        CustomerDto customerDto = createCustomerDto();

        CustomerPagedList pagedList = new CustomerPagedList(List.of(customerDto), PageRequest.of(1, 1), 1L);

        String json = objectMapper.writeValueAsString(pagedList);

        CustomerPagedList deserializedPagedList = objectMapper.readValue(json, CustomerPagedList.class);

        assertAll("CustomerPagedList Deserialization with PageRequest", () -> assertNotNull(deserializedPagedList),
                () -> assertEquals(1, deserializedPagedList.getContent().size()),
                () -> assertEquals(customerDto.getId(), deserializedPagedList.getContent().getFirst().getId()));
    }

    @Test
    void testSerializeDeserializeUnpaged() {
        CustomerDto customerDto = createCustomerDto();

        // Default constructor uses Unpaged internally if not modified
        CustomerPagedList pagedList = new CustomerPagedList(List.of(customerDto));

        String json = objectMapper.writeValueAsString(pagedList);

        CustomerPagedList deserializedPagedList = objectMapper.readValue(json, CustomerPagedList.class);

        assertAll("CustomerPagedList Deserialization Unpaged", () -> assertNotNull(deserializedPagedList),
                () -> assertEquals(1, deserializedPagedList.getContent().size()),
                () -> assertEquals(customerDto.getId(), deserializedPagedList.getContent().getFirst().getId()));
    }

    @Test
    void testJsonCreatorWithNullDefaults() {
        CustomerDto customerDto = createCustomerDto();

        CustomerPagedList pagedList = new CustomerPagedList(List.of(customerDto), null, null, null, null, null, null,
                null, null, null);

        assertAll("CustomerPagedList JsonCreator null defaults", () -> assertEquals(1, pagedList.getContent().size()),
                () -> assertEquals(0, pagedList.getNumber()), () -> assertEquals(25, pagedList.getSize()),
                () -> assertEquals(1L, pagedList.getTotalElements()));
    }

    @Test
    void testConstructorWithEmptyContent() {
        CustomerPagedList pagedList = new CustomerPagedList(List.of());

        assertAll("CustomerPagedList empty content", () -> assertTrue(pagedList.getContent().isEmpty()),
                () -> assertEquals(0, pagedList.getNumber()), () -> assertEquals(1, pagedList.getSize()),
                () -> assertEquals(0L, pagedList.getTotalElements()));
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
