import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 5;
    static int raceStatus = 0;
    public static boolean winnerExists = false;

    public static void main(String[] args) {
        final String[] raceStatusMessages = new String[]{
                "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!",
                "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!",
                "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"};
        System.out.println(raceStatusMessages[raceStatus]);

        Semaphore semaphore = new Semaphore(Math.round(CARS_COUNT/2));
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT,
                ()-> {
            raceStatus= raceStatus+1;
            System.out.println(raceStatusMessages[raceStatus]);
        });

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cyclicBarrier);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }
}