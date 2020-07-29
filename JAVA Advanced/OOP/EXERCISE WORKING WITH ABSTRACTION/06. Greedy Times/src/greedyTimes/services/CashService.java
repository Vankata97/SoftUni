package greedyTimes.services;

import greedyTimes.Cash;

public interface CashService {
    boolean containsCash(String name);

    long totalCash();

    Cash findCashByName(String name);
}
