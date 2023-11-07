// Создаем класс Toy с полями id, название, количество и вес
class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    // Конструктор класса Toy
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    // Геттеры и сеттеры для полей класса Toy
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

// Создаем класс ToyStore для работы с игрушками
class ToyStore {
    private List<Toy> toys;

    // Конструктор класса ToyStore
    public ToyStore() {
        toys = new ArrayList<>();
    }

    // Метод для добавления новых игрушек
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    // Метод для изменения веса (частоты выпадения) игрушки
    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
            }
        }
    }

    // Метод для проведения розыгрыша игрушек
    public void startGiveaway() {
        // Суммируем веса всех игрушек
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        // Генерируем случайное число от 0 до суммарного веса
        double randomNum = Math.random() * totalWeight;

        // Находим игрушку с соответствующим весом
        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomNum <= cumulativeWeight) {
                // Выводим название выбранной игрушки
                System.out.println("Выиграна игрушка: " + toy.getName());
                break;
            }
        }
    }
}

// Создаем объект класса ToyStore и добавляем игрушки
ToyStore toyStore = new ToyStore();
toyStore.addToy(new Toy(1, "Мяч", 10, 25));
toyStore.addToy(new Toy(2, "Кукла", 5, 15));
toyStore.addToy(new Toy(3, "Машинка", 3, 30));

// Изменяем вес игрушки с id=2
toyStore.changeWeight(2, 10);

// Запускаем розыгрыш
toyStore.startGiveaway();
