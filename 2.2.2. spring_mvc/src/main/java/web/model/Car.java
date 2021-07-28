package web.model;

public class Car {
    private String marka;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String marka, String model, int year) {
        this.marka = marka;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Автомобиль: <span style=\"color: #ff0000;\">%s %s</span>, год выпуска %d\n", marka, model, year);
    }
}
