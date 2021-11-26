public class Human extends Creature implements Runable,Jumpable{
    public Human(int maxJumpHeight, int maxRunLength){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.creatureName = "Человек";
    }
}
