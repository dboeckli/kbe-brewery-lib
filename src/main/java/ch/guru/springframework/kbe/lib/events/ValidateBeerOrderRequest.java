package ch.guru.springframework.kbe.lib.events;

import ch.guru.springframework.kbe.lib.dto.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 2019-09-08.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidateBeerOrderRequest {
    private BeerOrderDto beerOrder;
}
