package application;

import models.Order;

public class SecondRewardProcessor implements RewardChain {
    private RewardChain nextInChain;

    public void setNext(RewardChain nextInChain) {
        this.nextInChain = nextInChain;
    }

    public void process(Order request) {
        if (request.getAmount() > 50) {
            request.getCustomer().setPoints((int) (request.getCustomer().getPoints() + (request.getAmount() - 50) * 1));
        }

        if (nextInChain != null) {
            nextInChain.process(request);
        }
    }
}
