package application;

import models.Customer;
import models.Order;

public class ApplicationMain {
    public static void main(String args[]){
        System.out.println("Rewards Program");

        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).build();
        Order order = Order.builder().orderNumber("1").customer(customer1).amount(120.0f).build();
        RewardContext context = new RewardContext();
        context.process(order);

        System.out.println("Reward Points for Customer " + customer1.getName() + " = " + customer1.getPoints());

    }
}
