package serverpart;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService {
    private List<Entry> entries;


    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }


    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
    }


    public String getNickByLoginPass(String login, String pass) {
        for (Entry o : entries) {
            if (o.getLogin().equals(login) && o.getPass().equals(pass)) return o.getNick();
        }
        return null;

    }

}
