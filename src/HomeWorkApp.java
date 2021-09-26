public class HomeWorkApp {
    public static void main (String[] args){
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ushin Ilya Aleksandrovich", "Direktor", "iushin@gmail.com","89034562378",500000,45);
        persArray[1] = new Person("Fadeeva Olga Ivanovna", "Engineer", "ofadeeva@gmail.com","89033364378",50000,27);
        persArray[2] = new Person("Soloviev Andrey Markovichb", "Engineer", "asoloviev@gmail.com","89443364437",90000,25);
        persArray[3] = new Person("Nikolaev Artem Igorevich", "Manager", "anikolaev@gmail.com","89679823405",70000,30);
        persArray[4] = new Person("Korotaeva Anna Nikolaevna", "Analytic Manager", "anikolaev@gmail.com","82730495639",100000,19);

        for (int i=0; i<persArray.length; i++){
            System.out.println("Сотрудник №"+(i+1));
            persArray[i].outputPersonalInfo();
            System.out.println();
        }
}}
