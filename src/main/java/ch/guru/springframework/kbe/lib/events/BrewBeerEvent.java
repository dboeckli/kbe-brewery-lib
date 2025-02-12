package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerDto;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 5294557463904704401L;

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }

}
