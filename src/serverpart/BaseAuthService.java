package serverpart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BaseAuthService {
    private List<Entry> entries;
    final Logger LOGGER_AUTHSERVICE = LogManager.getLogger(BaseAuthService.class);


    public void start() {
        LOGGER_AUTHSERVICE.info("Сервис аутентификации запущен");
    }

    public void stop() {
        LOGGER_AUTHSERVICE.info("Сервис аутентификации остановлен");
    }

    public BaseAuthService(DatabaseReader dbReader) {
        entries = dbReader.getArrayWithUsers();
    }

    public String getNickByLoginPass(String login, String pass) {
        for (Entry o : entries) {
            if (o.getLogin().equals(login) && o.getPass().equals(pass)) {
                LOGGER_AUTHSERVICE.debug("Пользователь "+o.getNick()+" успешно авторизовался");
                return o.getNick();
            }
        }
        return null;

    }

}
