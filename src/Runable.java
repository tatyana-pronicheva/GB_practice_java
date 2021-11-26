public interface Runable{
    default void run(int obstacleSize){
        System.out.println("Пробегает дорожку "+ obstacleSize +"см");
    };
}
