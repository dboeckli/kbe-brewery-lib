package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerDto;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = -1761313326070018802L;

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
