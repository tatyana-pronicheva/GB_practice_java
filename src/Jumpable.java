public interface Jumpable {
    default void jump(int obstacleSize){
        System.out.println("Перепрыгивает стену "+ obstacleSize +"см");
    };
}
