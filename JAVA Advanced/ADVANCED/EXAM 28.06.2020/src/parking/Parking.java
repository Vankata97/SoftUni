package parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private Collection<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Car> getData() {
        return (List<Car>) data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {

        return data.removeIf(m -> m.getManufacturer().equals(manufacturer) && m.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car car = this.data.stream()
                .max(Comparator.comparingDouble(Car::getYear)).orElse(null);
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = this.data.stream().filter(m -> m.getManufacturer().equals(manufacturer) && m.getModel().equals(model)).findFirst().orElse(null);
        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder(String.format("The cars are parked in %s:%n", this.type));
        for (Car car : this.data) {
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
