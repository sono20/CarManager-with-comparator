import java.util.*;

public class CarManager {
    static class Car {
        private String brand;
        private String model;
        private int year;

        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() { return brand; }
        public String getModel() { return model; }
        public int getYear() { return year; }

        public String toString() {
            return brand + " | " + model + " | " + year;
        }
    }

    private List<Car> cars = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCar() {
        System.out.print("Podaj markę: ");
        String brand = scanner.nextLine();
        System.out.print("Podaj model: ");
        String model = scanner.nextLine();
        System.out.print("Podaj rok: ");
        int year = Integer.parseInt(scanner.nextLine());

        cars.add(new Car(brand, model, year));
        System.out.println("Dodano samochód.\n");
    }

    public void sortCars() {
        System.out.println("Sortować według:");
        System.out.println("1. Marka");
        System.out.println("2. Model");
        System.out.println("3. Rok");
        System.out.print("Wybór: ");

        String choice = scanner.nextLine();
        Comparator<Car> comp;

        switch (choice) {
            case "1":
                comp = Comparator.comparing(Car::getBrand);
                break;
            case "2":
                comp = Comparator.comparing(Car::getModel);
                break;
            case "3":
                comp = Comparator.comparingInt(Car::getYear);
                break;
            default:
                System.out.println("Nieznana opcja.");
                return;
        }

        cars.sort(comp);
        System.out.println("Posortowano.\n");
    }

    public void listCars() {
        System.out.println("\n=== Lista samochodów ===");
        if (cars.isEmpty()) {
            System.out.println("Brak samochodów.\n");
            return;
        }
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.println();
    }

    public void menu() {
        while (true) {
            System.out.println("=== Car Manager ===");
            System.out.println("1. Dodaj samochód");
            System.out.println("2. Wyświetl samochody");
            System.out.println("3. Sortuj");
            System.out.println("4. Wyjście");
            System.out.print("Wybór: ");

            switch (scanner.nextLine()) {
                case "1": addCar(); break;
                case "2": listCars(); break;
                case "3": sortCars(); break;
                case "4": return;
                default:
                    System.out.println("Nieznana opcja.\n");
            }
        }
    }

    public static void main(String[] args) {
        new CarManager().menu();
    }
}
