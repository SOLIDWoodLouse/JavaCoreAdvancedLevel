package lesson01;

public class Main {


    public static Movement[] movements = {
            new Human(10, 3, "Петя"),
            new Cat(20, 9, "Пушистик"),
            new Robot(100, 50, "Чапи")
    };

    public static Passing[] passings = {
            new Wall(2),
            new Treadmill(1),
            new Wall(3),
            new Treadmill(2),
            new Wall(9),
            new Treadmill(3),
            new Wall(10),
            new Treadmill(4)
    };

    public static void main(String[] args) {

        startAction(movements, passings);

    }

    static void startAction(Movement[] movements, Passing[] passings) {

        for (Movement movement : movements) {
            int maxPassing = 0;
            for (Passing passing : passings) {
                if (passing.name().equals("Стена")) {
                    if (passing.startMove(movement.getMaxHeight())) {
                        maxPassing++;
                        movement.jump();
                    } else break;
                } else {
                    if (passing.startMove(movement.getMaxLength())) {
                        maxPassing++;
                        movement.run();
                    } else break;
                }
            }
            if (maxPassing == passings.length) {
                System.out.println(movement.getName() + " прошел все препятствия");
            } else {
                System.out.println(movement.getName() + " завалился на " + (maxPassing + 1) + " препятствии и прошел "
                        + maxPassing + " из " + passings.length);
            }
        }

    }

}
