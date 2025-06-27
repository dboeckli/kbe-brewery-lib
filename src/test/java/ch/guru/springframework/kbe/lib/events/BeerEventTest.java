package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerDto;
import ch.guru.springframework.kbe.lib.dto.BeerStyleEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerEventTest {

    @Test
    void testNoArgsConstructor() {
        BeerEvent beerEvent = new BeerEvent();

        assertNull(beerEvent.getBeerDto());
    }

    @Test
    void testAllArgsConstructor() {
        BeerDto beerDto = createSampleBeerDto();

        BeerEvent beerEvent = new BeerEvent(beerDto);

        assertEquals(beerDto, beerEvent.getBeerDto());
    }

    @Test
    void testBuilder() {
        BeerDto beerDto = createSampleBeerDto();

        BeerEvent beerEvent = BeerEvent.builder()
                .beerDto(beerDto)
                .build();

        assertEquals(beerDto, beerEvent.getBeerDto());
    }

    @Test
    void testGettersAndSetters() {
        BeerEvent beerEvent = new BeerEvent();

        BeerDto beerDto = createSampleBeerDto();
        beerEvent.setBeerDto(beerDto);

        assertEquals(beerDto, beerEvent.getBeerDto());
    }

    @Test
    void testEqualsAndHashCode() {
        BeerDto beerDto = createSampleBeerDto();

        BeerEvent beerEvent1 = BeerEvent.builder()
                .beerDto(beerDto)
                .build();

        BeerEvent beerEvent2 = BeerEvent.builder()
                .beerDto(beerDto)
                .build();

        assertAll(
            () -> assertEquals(beerEvent1, beerEvent2),
            () -> assertEquals(beerEvent1.hashCode(), beerEvent2.hashCode())
        );

        // Change a property to verify equals works correctly
        BeerDto differentBeerDto = createSampleBeerDto();
        differentBeerDto.setBeerName("Different Beer");
        beerEvent2.setBeerDto(differentBeerDto);

        assertNotEquals(beerEvent1, beerEvent2);
    }

    private BeerDto createSampleBeerDto() {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Test Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc("12345")
                .price(new BigDecimal("10.99"))
                .build();
    }
}
