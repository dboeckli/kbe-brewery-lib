package ch.guru.springframework.kbe.lib.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerOrderValidationResult {
    private Boolean isValid;
    private UUID beerOrderId;
}
