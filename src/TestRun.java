public class TestRun {
    @BeforeSuite
    public void init(){
        System.out.println("Выполняется подготовка к тестам перед запуском сьюта");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Выполняется тест1");
    }

    @Test(priority = 10)
    public void test2(){
        System.out.println("Выполняется тест2");
    }

    @Test()
    public void test3(){
        System.out.println("Выполняется тест3");
    }

    @AfterSuite
    public void closing(){
        System.out.println("Выполняется завершающий метод");
    }
}
