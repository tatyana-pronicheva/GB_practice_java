public class Cat extends Creature implements Runable,Jumpable{    public Cat(int maxJumpHeight, int maxRunLength){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.creatureName = "Кошка";
    }
}
