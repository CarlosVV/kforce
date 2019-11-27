package application;


import models.Customer;
import models.Order;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class RewardContextTest {
    @Test
    public void testRewardFor120() {
        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).pointsPerMonth(new HashMap<>()).build();
        Order order = Order.builder().orderNumber("1").customer(customer1).amount(120.0f).build();
        RewardContext context = new RewardContext();
        context.process(order);
        assertEquals("Rewards for 120", Integer.valueOf(110), customer1.getPoints());
    }

    @Test
    public void testRewardFor100() {
        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).pointsPerMonth(new HashMap<>()).build();
        Order order = Order.builder().orderNumber("1").customer(customer1).amount(100.0f).build();
        RewardContext context = new RewardContext();
        context.process(order);
        assertEquals("Rewards for 100", Integer.valueOf(50), customer1.getPoints());
    }

    @Test
    public void testRewardFor10() {
        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).pointsPerMonth(new HashMap<>()).build();
        Order order = Order.builder().orderNumber("1").customer(customer1).amount(10.0f).build();
        RewardContext context = new RewardContext();
        context.process(order);
        assertEquals("Rewards for 10", Integer.valueOf(0), customer1.getPoints());
    }

    @Test
    public void testRewardFor50() {
        Customer customer1 = Customer.builder().name("Carlos Valderrama").points(0).pointsPerMonth(new HashMap<>()).build();
        Order order = Order.builder().orderNumber("1").customer(customer1).amount(50.0f).build();
        RewardContext context = new RewardContext();
        context.process(order);
        assertEquals("Rewards for 50", Integer.valueOf(0), customer1.getPoints());
    }
}
