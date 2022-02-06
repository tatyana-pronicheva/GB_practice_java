package serverpart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader {
        private Connection connection;
        private static Statement stmt;
        final Logger LOGGER_DATABASE = LogManager.getLogger(DatabaseReader.class);


    public void start() {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:userdb.db");
                stmt = connection.createStatement();
                LOGGER_DATABASE.info("Соединение с базой данных userdb установлено");
            } catch (SQLException e){
                LOGGER_DATABASE.error("Ошибка соединения с базой данных userdb" + e);
            }
        }

        public void stop() {
            try {
                if (connection != null) {
                    connection.close();
                    LOGGER_DATABASE.info("Соединение с базой данных закрыто");
                }
            } catch (SQLException e) {
                LOGGER_DATABASE.error("Ошибка при остановке соединения с базой данных userdb" + e);
            }
        }
        public List<Entry> getArrayWithUsers(){
            try {
                ResultSet result = stmt.executeQuery("SELECT * FROM users;");
                LOGGER_DATABASE.info("Инфо о юзерах прочитано из базы данных");
                List<Entry>  entries = new ArrayList<>();
                while (result.next()) {
                    entries.add(
                           new Entry(
                                    result.getString("login"),
                                    result.getString("password"),
                                    result.getString("nickname")
                           ));
                }
                return entries;
            }
            catch (SQLException e){
                LOGGER_DATABASE.error("Ошибка при чтении данных из userdb" + e);
            }
            return null;
        }
}



