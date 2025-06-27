package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerDtoTest {

    @Test
    void testNoArgsConstructor() {
        BeerDto beerDto = new BeerDto();
        
        assertNull(beerDto.getId());
        assertNull(beerDto.getVersion());
        assertNull(beerDto.getCreatedDate());
        assertNull(beerDto.getLastModifiedDate());
        assertNull(beerDto.getBeerName());
        assertNull(beerDto.getBeerStyle());
        assertNull(beerDto.getUpc());
        assertNull(beerDto.getQuantityOnHand());
        assertNull(beerDto.getPrice());
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        String beerName = "Test Beer";
        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        String upc = "12345";
        Integer quantityOnHand = 10;
        BigDecimal price = new BigDecimal("10.99");

        BeerDto beerDto = new BeerDto(id, version, createdDate, lastModifiedDate, 
                                      beerName, beerStyle, upc, quantityOnHand, price);
        
        assertEquals(id, beerDto.getId());
        assertEquals(version, beerDto.getVersion());
        assertEquals(createdDate, beerDto.getCreatedDate());
        assertEquals(lastModifiedDate, beerDto.getLastModifiedDate());
        assertEquals(beerName, beerDto.getBeerName());
        assertEquals(beerStyle, beerDto.getBeerStyle());
        assertEquals(upc, beerDto.getUpc());
        assertEquals(quantityOnHand, beerDto.getQuantityOnHand());
        assertEquals(price, beerDto.getPrice());
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        String beerName = "Test Beer";
        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        String upc = "12345";
        Integer quantityOnHand = 10;
        BigDecimal price = new BigDecimal("10.99");

        BeerDto beerDto = BeerDto.builder()
                .id(id)
                .version(version)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .beerName(beerName)
                .beerStyle(beerStyle)
                .upc(upc)
                .quantityOnHand(quantityOnHand)
                .price(price)
                .build();
        
        assertEquals(id, beerDto.getId());
        assertEquals(version, beerDto.getVersion());
        assertEquals(createdDate, beerDto.getCreatedDate());
        assertEquals(lastModifiedDate, beerDto.getLastModifiedDate());
        assertEquals(beerName, beerDto.getBeerName());
        assertEquals(beerStyle, beerDto.getBeerStyle());
        assertEquals(upc, beerDto.getUpc());
        assertEquals(quantityOnHand, beerDto.getQuantityOnHand());
        assertEquals(price, beerDto.getPrice());
    }

    @Test
    void testGettersAndSetters() {
        BeerDto beerDto = new BeerDto();
        
        UUID id = UUID.randomUUID();
        beerDto.setId(id);
        assertEquals(id, beerDto.getId());
        
        Integer version = 1;
        beerDto.setVersion(version);
        assertEquals(version, beerDto.getVersion());
        
        OffsetDateTime createdDate = OffsetDateTime.now();
        beerDto.setCreatedDate(createdDate);
        assertEquals(createdDate, beerDto.getCreatedDate());
        
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        beerDto.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, beerDto.getLastModifiedDate());
        
        String beerName = "Test Beer";
        beerDto.setBeerName(beerName);
        assertEquals(beerName, beerDto.getBeerName());
        
        BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
        beerDto.setBeerStyle(beerStyle);
        assertEquals(beerStyle, beerDto.getBeerStyle());
        
        String upc = "12345";
        beerDto.setUpc(upc);
        assertEquals(upc, beerDto.getUpc());
        
        Integer quantityOnHand = 10;
        beerDto.setQuantityOnHand(quantityOnHand);
        assertEquals(quantityOnHand, beerDto.getQuantityOnHand());
        
        BigDecimal price = new BigDecimal("10.99");
        beerDto.setPrice(price);
        assertEquals(price, beerDto.getPrice());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        BeerDto beerDto1 = BeerDto.builder()
                .id(id)
                .beerName("Test Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc("12345")
                .price(new BigDecimal("10.99"))
                .build();
        
        BeerDto beerDto2 = BeerDto.builder()
                .id(id)
                .beerName("Test Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc("12345")
                .price(new BigDecimal("10.99"))
                .build();
        
        assertEquals(beerDto1, beerDto2);
        assertEquals(beerDto1.hashCode(), beerDto2.hashCode());
        
        // Change a property to verify equals works correctly
        beerDto2.setBeerName("Different Beer");
        assertNotEquals(beerDto1, beerDto2);
    }
}