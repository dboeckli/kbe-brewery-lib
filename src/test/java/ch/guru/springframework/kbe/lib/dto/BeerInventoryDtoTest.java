package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerInventoryDtoTest {

    @Test
    void testNoArgsConstructor() {
        BeerInventoryDto dto = new BeerInventoryDto();
        
        assertNull(dto.getId());
        assertNull(dto.getCreatedDate());
        assertNull(dto.getLastModifiedDate());
        assertNull(dto.getBeerId());
        assertNull(dto.getQuantityOnHand());
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID beerId = UUID.randomUUID();
        Integer quantityOnHand = 10;

        BeerInventoryDto dto = new BeerInventoryDto(id, createdDate, lastModifiedDate, beerId, quantityOnHand);
        
        assertEquals(id, dto.getId());
        assertEquals(createdDate, dto.getCreatedDate());
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());
        assertEquals(beerId, dto.getBeerId());
        assertEquals(quantityOnHand, dto.getQuantityOnHand());
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID beerId = UUID.randomUUID();
        Integer quantityOnHand = 10;

        BeerInventoryDto dto = BeerInventoryDto.builder()
                .id(id)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .beerId(beerId)
                .quantityOnHand(quantityOnHand)
                .build();
        
        assertEquals(id, dto.getId());
        assertEquals(createdDate, dto.getCreatedDate());
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());
        assertEquals(beerId, dto.getBeerId());
        assertEquals(quantityOnHand, dto.getQuantityOnHand());
    }

    @Test
    void testGettersAndSetters() {
        BeerInventoryDto dto = new BeerInventoryDto();
        
        UUID id = UUID.randomUUID();
        dto.setId(id);
        assertEquals(id, dto.getId());
        
        OffsetDateTime createdDate = OffsetDateTime.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());
        
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        dto.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());
        
        UUID beerId = UUID.randomUUID();
        dto.setBeerId(beerId);
        assertEquals(beerId, dto.getBeerId());
        
        Integer quantityOnHand = 10;
        dto.setQuantityOnHand(quantityOnHand);
        assertEquals(quantityOnHand, dto.getQuantityOnHand());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        UUID beerId = UUID.randomUUID();
        
        BeerInventoryDto dto1 = BeerInventoryDto.builder()
                .id(id)
                .beerId(beerId)
                .quantityOnHand(10)
                .build();
        
        BeerInventoryDto dto2 = BeerInventoryDto.builder()
                .id(id)
                .beerId(beerId)
                .quantityOnHand(10)
                .build();
        
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        
        // Change a property to verify equals works correctly
        dto2.setQuantityOnHand(20);
        assertNotEquals(dto1, dto2);
    }
}