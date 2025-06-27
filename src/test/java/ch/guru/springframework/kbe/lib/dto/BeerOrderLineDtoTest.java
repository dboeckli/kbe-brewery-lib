package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerOrderLineDtoTest {

    @Test
    void testNoArgsConstructor() {
        BeerOrderLineDto dto = new BeerOrderLineDto();

        assertAll(
            () -> assertNull(dto.getId()),
            () -> assertNull(dto.getVersion()),
            () -> assertNull(dto.getCreatedDate()),
            () -> assertNull(dto.getLastModifiedDate()),
            () -> assertNull(dto.getBeerId()),
            () -> assertNull(dto.getUpc()),
            () -> assertNull(dto.getBeerName()),
            () -> assertNull(dto.getBeerStyle()),
            () -> assertNull(dto.getOrderQuantity()),
            () -> assertNull(dto.getQuantityAllocated()),
            () -> assertNull(dto.getPrice())
        );
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID beerId = UUID.randomUUID();
        String upc = "12345";
        String beerName = "Test Beer";
        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        Integer orderQuantity = 10;
        Integer quantityAllocated = 5;
        BigDecimal price = new BigDecimal("10.99");

        BeerOrderLineDto dto = new BeerOrderLineDto(id, version, createdDate, lastModifiedDate, 
                                                  beerId, upc, beerName, beerStyle, 
                                                  orderQuantity, quantityAllocated, price);

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(beerId, dto.getBeerId()),
            () -> assertEquals(upc, dto.getUpc()),
            () -> assertEquals(beerName, dto.getBeerName()),
            () -> assertEquals(beerStyle, dto.getBeerStyle()),
            () -> assertEquals(orderQuantity, dto.getOrderQuantity()),
            () -> assertEquals(quantityAllocated, dto.getQuantityAllocated()),
            () -> assertEquals(price, dto.getPrice())
        );
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID beerId = UUID.randomUUID();
        String upc = "12345";
        String beerName = "Test Beer";
        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        Integer orderQuantity = 10;
        Integer quantityAllocated = 5;
        BigDecimal price = new BigDecimal("10.99");

        BeerOrderLineDto dto = BeerOrderLineDto.builder()
                .id(id)
                .version(version)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .beerId(beerId)
                .upc(upc)
                .beerName(beerName)
                .beerStyle(beerStyle)
                .orderQuantity(orderQuantity)
                .quantityAllocated(quantityAllocated)
                .price(price)
                .build();

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(beerId, dto.getBeerId()),
            () -> assertEquals(upc, dto.getUpc()),
            () -> assertEquals(beerName, dto.getBeerName()),
            () -> assertEquals(beerStyle, dto.getBeerStyle()),
            () -> assertEquals(orderQuantity, dto.getOrderQuantity()),
            () -> assertEquals(quantityAllocated, dto.getQuantityAllocated()),
            () -> assertEquals(price, dto.getPrice())
        );
    }

    @Test
    void testGettersAndSetters() {
        BeerOrderLineDto dto = new BeerOrderLineDto();

        UUID id = UUID.randomUUID();
        dto.setId(id);
        assertEquals(id, dto.getId());

        Integer version = 1;
        dto.setVersion(version);
        assertEquals(version, dto.getVersion());

        OffsetDateTime createdDate = OffsetDateTime.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());

        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        dto.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());

        UUID beerId = UUID.randomUUID();
        dto.setBeerId(beerId);
        assertEquals(beerId, dto.getBeerId());

        String upc = "12345";
        dto.setUpc(upc);
        assertEquals(upc, dto.getUpc());

        String beerName = "Test Beer";
        dto.setBeerName(beerName);
        assertEquals(beerName, dto.getBeerName());

        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        dto.setBeerStyle(beerStyle);
        assertEquals(beerStyle, dto.getBeerStyle());

        Integer orderQuantity = 10;
        dto.setOrderQuantity(orderQuantity);
        assertEquals(orderQuantity, dto.getOrderQuantity());

        Integer quantityAllocated = 5;
        dto.setQuantityAllocated(quantityAllocated);
        assertEquals(quantityAllocated, dto.getQuantityAllocated());

        BigDecimal price = new BigDecimal("10.99");
        dto.setPrice(price);
        assertEquals(price, dto.getPrice());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        UUID beerId = UUID.randomUUID();
        
        BeerOrderLineDto dto1 = BeerOrderLineDto.builder()
                .id(id)
                .beerId(beerId)
                .upc("12345")
                .beerName("Test Beer")
                .orderQuantity(10)
                .build();

        BeerOrderLineDto dto2 = BeerOrderLineDto.builder()
                .id(id)
                .beerId(beerId)
                .upc("12345")
                .beerName("Test Beer")
                .orderQuantity(10)
                .build();

        assertAll(
            () -> assertEquals(dto1, dto2),
            () -> assertEquals(dto1.hashCode(), dto2.hashCode())
        );

        // Change a property to verify equals works correctly
        dto2.setOrderQuantity(20);
        assertNotEquals(dto1, dto2);
    }
}