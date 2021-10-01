public class HomeWorkApp {
    public static void main(String[] args){
        Dog dogBobik = new Dog();
        dogBobik.run(200);
        dogBobik.run(700);
        dogBobik.swim(10);
        dogBobik.swim(11);

        Cat catVasya = new Cat();
        catVasya.run(100);
        catVasya.run(400);
        catVasya.swim();

        Animal.counter();
    }
}
