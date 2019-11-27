package models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Customer {
    private String name;
    private Map<String, Integer> pointsPerMonth;
    private Integer points;
}
