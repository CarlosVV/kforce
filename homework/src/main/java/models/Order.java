package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderNumber;
    private Customer customer;
    private Float amount;
    private String month;
}
