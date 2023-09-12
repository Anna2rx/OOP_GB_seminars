// Общий класс родитель
class Participant {
    protected String name;
    protected int runLimit;
    protected int jumpLimit;

    public Participant(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " успешно пробежал дистанцию");
        } else {
            System.out.println(name + " не смог пробежать дистанцию");
        }
    }

    public void jump(int height) {
        if (height <= jumpLimit) {
            System.out.println(name + " успешно перепрыгнул препятствие");
        } else {
            System.out.println(name + " не смог перепрыгнуть препятствие");
        }
    }
}

// Класс Человек
class Human extends Participant {
    public Human(String name, int runLimit, int jumpLimit) {
        super(name, runLimit, jumpLimit);
    }
}

// Класс Кот
class Cat extends Participant {
    public Cat(String name, int runLimit, int jumpLimit) {
        super(name, runLimit, jumpLimit);
    }
}

// Класс Робот
class Robot extends Participant {
    public Robot(String name, int runLimit, int jumpLimit) {
        super(name, runLimit, jumpLimit);
    }
}

// Класс Беговая дорожка
class Treadmill {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public void pass(Participant participant) {
        participant.run(length);
    }
}

// Класс Стена
class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void pass(Participant participant) {
        participant.jump(height);
    }
}

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Иван", 100, 2),
                new Cat("Мурзик", 200, 3),
                new Robot("R2D2", 500, 10)
        };

        Object[] obstacles = {
                new Treadmill(150),
                new Wall(3),
                new Treadmill(300),
                new Wall(5)
        };

        for (Participant participant : participants) {
            boolean passedAllObstacles = true;
            for (Object obstacle : obstacles) {
                if (obstacle instanceof Treadmill) {
                    Treadmill treadmill = (Treadmill) obstacle;
                    treadmill.pass(participant);
                } else if (obstacle instanceof Wall) {
                    Wall wall = (Wall) obstacle;
                    wall.pass(participant);
                }

                // Если участник не смог пройти препятствие, то дальше по списку он не идет
                if (participant.runLimit <= 0 || participant.jumpLimit <= 0) {
                    passedAllObstacles = false;
                    break;
                }
            }

            if (passedAllObstacles) {
                System.out.println(participant.name + " успешно прошел все препятствия");
            } else {
                System.out.println(participant.name + " не смог пройти все препятствия");
            }
        }
    }
}