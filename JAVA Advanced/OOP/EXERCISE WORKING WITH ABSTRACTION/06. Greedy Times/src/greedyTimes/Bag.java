package greedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private Gold gold;
    private List<Gem> gems;
    private List<Cash> cash;
    private long capacity;

    public Bag(long capacity) {
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
        this.capacity = capacity;

    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Cash> getCash() {
        return cash;
    }

    public void setCash(List<Cash> cash) {
        this.cash = cash;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public boolean doesGemsContainsGem(String name) {
        for (Gem current : this.getGems()) {
            if (current.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public long totalGems() {
        return this.getGems().stream().mapToLong(Gem::getValue).sum();
    }

    public boolean containsCash(String name) {
        for (Cash current : this.getCash()) {
            if (current.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public long totalCash() {
        return this.getCash().stream().mapToLong(Cash::getValue).sum();
    }
}
