package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    @Test
    void testNoArgsConstructor() {
        CustomerDto dto = new CustomerDto();

        assertAll(
            () -> assertNull(dto.getId()),
            () -> assertNull(dto.getVersion()),
            () -> assertNull(dto.getCreatedDate()),
            () -> assertNull(dto.getLastModifiedDate()),
            () -> assertNull(dto.getCustomerName())
        );
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        Long version = 1L;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        String customerName = "Test Customer";

        CustomerDto dto = new CustomerDto(id, version, createdDate, lastModifiedDate, customerName);

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(customerName, dto.getCustomerName())
        );
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();
        Long version = 1L;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        String customerName = "Test Customer";

        CustomerDto dto = CustomerDto.builder()
                .id(id)
                .version(version)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .customerName(customerName)
                .build();

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(customerName, dto.getCustomerName())
        );
    }

    @Test
    void testGettersAndSetters() {
        CustomerDto dto = new CustomerDto();

        UUID id = UUID.randomUUID();
        dto.setId(id);
        assertEquals(id, dto.getId());

        Long version = 1L;
        dto.setVersion(version);
        assertEquals(version, dto.getVersion());

        OffsetDateTime createdDate = OffsetDateTime.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());

        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        dto.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());

        String customerName = "Test Customer";
        dto.setCustomerName(customerName);
        assertEquals(customerName, dto.getCustomerName());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        
        CustomerDto dto1 = CustomerDto.builder()
                .id(id)
                .customerName("Test Customer")
                .build();

        CustomerDto dto2 = CustomerDto.builder()
                .id(id)
                .customerName("Test Customer")
                .build();

        assertAll(
            () -> assertEquals(dto1, dto2),
            () -> assertEquals(dto1.hashCode(), dto2.hashCode())
        );

        // Change a property to verify equals works correctly
        dto2.setCustomerName("Different Customer");
        assertNotEquals(dto1, dto2);
    }
}