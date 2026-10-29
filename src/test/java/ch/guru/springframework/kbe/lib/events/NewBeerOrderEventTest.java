package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerOrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NewBeerOrderEventTest {

    @Test
    void testConstructorStoresBeerOrderDto() {
        BeerOrderDto beerOrderDto = createSampleBeerOrderDto();

        NewBeerOrderEvent event = new NewBeerOrderEvent(beerOrderDto);

        assertAll(() -> assertEquals(beerOrderDto, event.getSource()),
                () -> assertEquals(beerOrderDto, event.getBeerOrder()));
    }

    @Test
    void testIsApplicationEvent() {
        NewBeerOrderEvent event = new NewBeerOrderEvent(createSampleBeerOrderDto());

        assertInstanceOf(ApplicationEvent.class, event);
    }

    private BeerOrderDto createSampleBeerOrderDto() {
        return BeerOrderDto.builder().id(UUID.randomUUID()).customerRef("customer-ref").build();
    }

}
