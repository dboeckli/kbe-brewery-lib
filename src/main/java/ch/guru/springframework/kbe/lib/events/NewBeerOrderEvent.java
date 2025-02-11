package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerOrderDto;
import org.springframework.context.ApplicationEvent;

public class NewBeerOrderEvent extends ApplicationEvent {

    public NewBeerOrderEvent(BeerOrderDto source) {
        super(source);
    }

    public BeerOrderDto getBeerOrder(){
        return (BeerOrderDto) this.source;
    }
}
