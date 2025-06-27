package ch.guru.springframework.kbe.lib.dto;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerOrderDtoTest {

    @Test
    void testNoArgsConstructor() {
        BeerOrderDto dto = new BeerOrderDto();

        assertAll(
            () -> assertNull(dto.getId()),
            () -> assertNull(dto.getVersion()),
            () -> assertNull(dto.getCreatedDate()),
            () -> assertNull(dto.getLastModifiedDate()),
            () -> assertNull(dto.getCustomerId()),
            () -> assertNull(dto.getCustomerRef()),
            () -> assertNull(dto.getBeerOrderLines()),
            () -> assertNull(dto.getOrderStatus()),
            () -> assertNull(dto.getOrderStatusCallbackUrl())
        );
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID customerId = UUID.randomUUID();
        String customerRef = "Test Ref";
        List<BeerOrderLineDto> beerOrderLines = new ArrayList<>();
        String orderStatus = "NEW";
        String orderStatusCallbackUrl = "http://example.com/callback";

        BeerOrderDto dto = new BeerOrderDto(id, version, createdDate, lastModifiedDate, 
                                           customerId, customerRef, beerOrderLines, 
                                           orderStatus, orderStatusCallbackUrl);

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(customerId, dto.getCustomerId()),
            () -> assertEquals(customerRef, dto.getCustomerRef()),
            () -> assertEquals(beerOrderLines, dto.getBeerOrderLines()),
            () -> assertEquals(orderStatus, dto.getOrderStatus()),
            () -> assertEquals(orderStatusCallbackUrl, dto.getOrderStatusCallbackUrl())
        );
    }

    @Test
    void testBuilder() {
        UUID id = UUID.randomUUID();
        Integer version = 1;
        OffsetDateTime createdDate = OffsetDateTime.now();
        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        UUID customerId = UUID.randomUUID();
        String customerRef = "Test Ref";
        List<BeerOrderLineDto> beerOrderLines = new ArrayList<>();
        String orderStatus = "NEW";
        String orderStatusCallbackUrl = "http://example.com/callback";

        BeerOrderDto dto = BeerOrderDto.builder()
                .id(id)
                .version(version)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .customerId(customerId)
                .customerRef(customerRef)
                .beerOrderLines(beerOrderLines)
                .orderStatus(orderStatus)
                .orderStatusCallbackUrl(orderStatusCallbackUrl)
                .build();

        assertAll(
            () -> assertEquals(id, dto.getId()),
            () -> assertEquals(version, dto.getVersion()),
            () -> assertEquals(createdDate, dto.getCreatedDate()),
            () -> assertEquals(lastModifiedDate, dto.getLastModifiedDate()),
            () -> assertEquals(customerId, dto.getCustomerId()),
            () -> assertEquals(customerRef, dto.getCustomerRef()),
            () -> assertEquals(beerOrderLines, dto.getBeerOrderLines()),
            () -> assertEquals(orderStatus, dto.getOrderStatus()),
            () -> assertEquals(orderStatusCallbackUrl, dto.getOrderStatusCallbackUrl())
        );
    }

    @Test
    void testGettersAndSetters() {
        BeerOrderDto dto = new BeerOrderDto();

        UUID id = UUID.randomUUID();
        dto.setId(id);
        assertEquals(id, dto.getId());

        Integer version = 1;
        dto.setVersion(version);
        assertEquals(version, dto.getVersion());

        OffsetDateTime createdDate = OffsetDateTime.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());

        OffsetDateTime lastModifiedDate = OffsetDateTime.now();
        dto.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, dto.getLastModifiedDate());

        UUID customerId = UUID.randomUUID();
        dto.setCustomerId(customerId);
        assertEquals(customerId, dto.getCustomerId());

        String customerRef = "Test Ref";
        dto.setCustomerRef(customerRef);
        assertEquals(customerRef, dto.getCustomerRef());

        List<BeerOrderLineDto> beerOrderLines = new ArrayList<>();
        dto.setBeerOrderLines(beerOrderLines);
        assertEquals(beerOrderLines, dto.getBeerOrderLines());

        String orderStatus = "NEW";
        dto.setOrderStatus(orderStatus);
        assertEquals(orderStatus, dto.getOrderStatus());

        String orderStatusCallbackUrl = "http://example.com/callback";
        dto.setOrderStatusCallbackUrl(orderStatusCallbackUrl);
        assertEquals(orderStatusCallbackUrl, dto.getOrderStatusCallbackUrl());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        
        BeerOrderDto dto1 = BeerOrderDto.builder()
                .id(id)
                .customerId(customerId)
                .customerRef("Test Ref")
                .orderStatus("NEW")
                .build();

        BeerOrderDto dto2 = BeerOrderDto.builder()
                .id(id)
                .customerId(customerId)
                .customerRef("Test Ref")
                .orderStatus("NEW")
                .build();

        assertAll(
            () -> assertEquals(dto1, dto2),
            () -> assertEquals(dto1.hashCode(), dto2.hashCode())
        );

        // Change a property to verify equals works correctly
        dto2.setOrderStatus("PENDING");
        assertNotEquals(dto1, dto2);
    }
}