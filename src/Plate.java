public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
            food -= n;
    }
    public void info() {
        System.out.println("В тарелке: " + food);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food){
        this.food +=food;
        System.out.println("Добавлена еда: +" + food);
    }
}
