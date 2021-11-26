import java.util.Random;

public class Course {
    int obstaclesCount;
    Obstacle[] obstacleSet;

    //create set with random obstacles
    public Course(int obstaclesCount, int maxWallHeight, int maxRoadLength){
        this.obstaclesCount = obstaclesCount;
        Random rand = new Random();
        obstacleSet = new Obstacle[obstaclesCount];
        for (int i = 0; i<obstaclesCount; i++){
            if (rand.nextInt(2) == 0){
                obstacleSet[i] = new Wall(rand.nextInt(maxWallHeight));
            } else{
                obstacleSet[i] = new Road(rand.nextInt(maxRoadLength));
            }
        }
    }

    public void printObstacleSet(){
        System.out.println("Полоса препятствий");
        for (int i = 0; i<obstaclesCount; i++){
            System.out.println((i+1)+") "+obstacleSet[i].obstacleType+" "+obstacleSet[i].obstacleSize+"см");
        }
    }

    public void dolt(Team team){

        for (int i = 0; i<team.participants.length; i++){
            System.out.println();
            System.out.println("Участник № "+(i+1));
            for (int j = 0; j<obstaclesCount; j++){
                if (obstacleSet[j] instanceof Wall)
                {
                    if (obstacleSet[j].obstacleSize>=team.participants[i].maxJumpHeight)
                    {
                        System.out.println("Не прошел препятствие № "+ (j+1));
                        team.participants[i].isWinner = false;
                        break;
                    } else{
                        team.participants[i].jump(obstacleSet[j].obstacleSize);
                        team.participants[i].isWinner = true;
                    }
                }else{
                    if (obstacleSet[j].obstacleSize>=team.participants[i].maxRunLength)
                    {
                        System.out.println("Не прошел препятствие № "+ (j+1));
                        team.participants[i].isWinner = false;
                        break;
                    } else{
                        team.participants[i].run(obstacleSet[j].obstacleSize);
                        team.participants[i].isWinner = true;
                    }
                }
            }
        }


    }
}
