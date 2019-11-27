package application;

import models.Order;

public class RewardContext {
    private RewardChain firstRewardProcessor = new FirstRewardProcessor();
    private RewardChain secondRewardProcessor = new SecondRewardProcessor();

    public RewardContext(){
        firstRewardProcessor.setNext(secondRewardProcessor);
    }

    public void process(Order order){
        firstRewardProcessor.process(order);
    }
}
