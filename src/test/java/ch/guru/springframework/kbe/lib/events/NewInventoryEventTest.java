package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerDto;
import ch.guru.springframework.kbe.lib.dto.BeerStyleEnum;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NewInventoryEventTest {

    @Test
    void testNoArgsConstructor() {
        NewInventoryEvent event = new NewInventoryEvent();

        assertNull(event.getBeerDto());
    }

    @Test
    void testConstructorWithBeerDto() {
        BeerDto beerDto = createSampleBeerDto();

        NewInventoryEvent event = new NewInventoryEvent(beerDto);

        assertEquals(beerDto, event.getBeerDto());
    }

    @Test
    void testInheritanceFromBeerEvent() {
        NewInventoryEvent event = new NewInventoryEvent();

        assertInstanceOf(BeerEvent.class, event);
    }

    @Test
    void testImplementsSerializable() {
        NewInventoryEvent event = new NewInventoryEvent();

        assertInstanceOf(Serializable.class, event);
    }

    @Test
    void testIsSerializable() {
        NewInventoryEvent event = new NewInventoryEvent(createSampleBeerDto());

        assertDoesNotThrow(() -> {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                objectOutputStream.writeObject(event);
            }
            assertTrue(byteArrayOutputStream.size() > 0);
        });
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
