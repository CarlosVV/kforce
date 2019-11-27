package application;

import models.Order;

interface RewardChain {
    public abstract void setNext(RewardChain nextInChain);
    public abstract void process(Order request);
}
