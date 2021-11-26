public class Robot extends Creature implements Runable,Jumpable{
    public Robot(int maxJumpHeight, int maxRunLength){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.creatureName = "Робот";
    }
}
