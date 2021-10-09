public class Cat {
    private String name;
    private int appetite; //сколько еды съедает кот за прием пищи
    private boolean isFull; //сытость
    private String catName;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }
    public void eat(Plate p) {
        if (!isFull) {
            if (p.getFood() < appetite) {
                System.out.println("Кот "+ name +" не может поесть, еды в тарелке недостаточно. Он голоден");
            }else {
                p.decreaseFood(appetite);
                isFull = true;
                System.out.println("Кот "+ name +" съел " + appetite + " единиц еды. Он сыт");
            }
        } else{
            System.out.println("Кот "+ name +" не хочет есть, он сыт.");
        }
    }
}