package serverpart;

import java.util.List;

public class BaseAuthService {
    private List<Entry> entries;


    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }


    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    public BaseAuthService(DatabaseReader dbReader) {
        entries = dbReader.getArrayWithUsers();
    }

    public String getNickByLoginPass(String login, String pass) {
        for (Entry o : entries) {
            if (o.getLogin().equals(login) && o.getPass().equals(pass)) return o.getNick();
        }
        return null;

    }

}
