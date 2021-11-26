import java.util.Random;

public class Main {
    public static void main(String[] args){

    Course c = new Course(7,201,501);
    c.printObstacleSet();

    Team team = new Team(
        new Cat(200,501),
        new Robot(180,400),
        new Cat(150,450),
        new Human(190,300),
        "Чемпионы");

    c.dolt(team);

    team.printAllParticipants();
    team.printWinParticipants();

    }
}
