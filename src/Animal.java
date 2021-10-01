public class Animal {

    private static int count;
    public Animal(){
        count++;
    }
    public static void counter() {
        System.out.println("Количество созданных животных " + count);
    }

    public void run(int obstacleSize){
        System.out.println("Животное пробежало " + obstacleSize + " метров");
    }
    public void swim(int obstacleSize){
        System.out.println("Животное проплыло " + obstacleSize + " метров");
    }
}
