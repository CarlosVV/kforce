package application;

import models.Order;

public class FirstRewardProcessor implements RewardChain {
    private RewardChain nextInChain;

    public void setNext(RewardChain nextInChain) {
        this.nextInChain = nextInChain;

    }

    public void process(Order request) {
        if (request.getAmount() > 100) {
            request.getCustomer().setPoints((int) (request.getCustomer().getPoints() + (request.getAmount() - 100) * 2));

            Integer currentPoints = request.getCustomer().getPointsPerMonth().get(request.getMonth());
            if (currentPoints == null) {
                currentPoints = 0;
            }
            request.getCustomer().getPointsPerMonth().put(request.getMonth(), currentPoints + ((int) (request.getAmount() - 100) * 2));
        }

        if (nextInChain != null) {
            nextInChain.process(request);
        }
    }
}
