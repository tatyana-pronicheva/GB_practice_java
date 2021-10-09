public class MainClass {
    public static void main(String[] args) {
        Cat[] cats =  new Cat[5];
        cats[0] = new Cat("Вася",10);
        cats[1] = new Cat("Тикток",6);
        cats[2] = new Cat("Черныш",7);
        cats[3] = new Cat("Пушинка",5);
        cats[4] = new Cat("Снежок",5);

        Plate plate = new Plate(30);

        plate.info();
        for (int i =0; i<cats.length; i++){
            cats[i].eat(plate);
            plate.info();
        }

        plate.addFood(15);
        plate.info();

    }
}