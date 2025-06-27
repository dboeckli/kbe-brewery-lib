package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerDto;
import ch.guru.springframework.kbe.lib.dto.BeerStyleEnum;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BrewBeerEventTest {

    @Test
    void testNoArgsConstructor() {
        BrewBeerEvent event = new BrewBeerEvent();

        assertNull(event.getBeerDto());
    }

    @Test
    void testConstructorWithBeerDto() {
        BeerDto beerDto = createSampleBeerDto();

        BrewBeerEvent event = new BrewBeerEvent(beerDto);

        assertEquals(beerDto, event.getBeerDto());
    }

    @Test
    void testInheritanceFromBeerEvent() {
        BrewBeerEvent event = new BrewBeerEvent();

        assertInstanceOf(BeerEvent.class, event);
    }

    @Test
    void testImplementsSerializable() {
        BrewBeerEvent event = new BrewBeerEvent();

        assertInstanceOf(Serializable.class, event);
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