public class Dog extends Animal{
    public void run(int obstacleSize){
        if (obstacleSize<=500 &&obstacleSize>0) {
            System.out.println("Собака пробежала " + obstacleSize + " метров");
        } else {
            System.out.println("Собака не может пробежать " + obstacleSize + " метров");
        }
    }
    public void swim(int obstacleSize){
        if (obstacleSize<=10 &&obstacleSize>0) {
            System.out.println("Собака проплыла " + obstacleSize + " метров");
        } else {
            System.out.println("Собака не может проплыть " + obstacleSize + " метров");
        }
    }
}
