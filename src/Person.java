public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;
    public Person(){}

    public Person(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void outputPersonalInfo(){
        System.out.println("ФИО: "+fullName);
        System.out.println("Должность: "+fullName);
        System.out.println("Email: "+email);
        System.out.println("Номер телефона: "+phoneNumber);
        System.out.println("Зарплата: "+salary);
        System.out.println("Возраст: "+age);
    }
}
