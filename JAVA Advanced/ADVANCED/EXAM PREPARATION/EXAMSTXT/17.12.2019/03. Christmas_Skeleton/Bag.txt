package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present present = this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
        return present;
    }

    public Present getPresent(String name) {
        Present present = this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        return present;
    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(this.getColor())
                .append(" bag contains:")
                .append(System.lineSeparator());
        for (Present present : data) {
            out.append(present.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
