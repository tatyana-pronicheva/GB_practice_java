public class Cat extends Animal{
    public void run(int obstacleSize){
        if (obstacleSize<=200 &&obstacleSize>0) {
            System.out.println("Кот пробежал " + obstacleSize + " метров");
        } else {
            System.out.println("Кот не может пробежать " + obstacleSize + " метров");
        }
    }
    public void swim() {
        System.out.println("Кот не умеет плавать");
    }
}
