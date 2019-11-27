package application;

import models.Customer;
import models.Order;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ApplicationMain {
    public static void main(String[] args) {
        System.out.println("Rewards Program");

        //1. Data Setup for 1 Customer
        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).pointsPerMonth(new LinkedHashMap<>()).build();
        List<Order> record = Arrays.asList(Order.builder().orderNumber("1").customer(customer1).amount(120.0f).month("October").build(),
                                        Order.builder().orderNumber("2").customer(customer1).amount(100.0f).month("October").build(),
                                        Order.builder().orderNumber("3").customer(customer1).amount(100.0f).month("October").build(),
                                        Order.builder().orderNumber("4").customer(customer1).amount(120.0f).month("November").build(),
                                        Order.builder().orderNumber("5").customer(customer1).amount(100.0f).month("November").build(),
                                        Order.builder().orderNumber("6").customer(customer1).amount(100.0f).month("November").build(),
                                        Order.builder().orderNumber("7").customer(customer1).amount(120.0f).month("December").build(),
                                        Order.builder().orderNumber("8").customer(customer1).amount(100.0f).month("December").build(),
                                        Order.builder().orderNumber("9").customer(customer1).amount(100.0f).month("December").build());

        //2. Processing the record for Customer using Chain of Responsability Design Pattern
        RewardContext context = new RewardContext();

        for(Order o : record){
            context.process(o);
        }
        //3. Print result according the homework statement
        System.out.println("Total Reward Points for Customer " + customer1.getName() + " = " + customer1.getPoints());
        System.out.println("Total Reward Points for Customer Per Month: ");
        customer1.getPointsPerMonth().forEach((m, q) -> {
            System.out.println(m + " = " + q);
        });
    }
}
