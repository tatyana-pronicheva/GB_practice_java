package serverpart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader {
        private Connection connection;
        private static Statement stmt;


    public void start() {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:userdb.db");
                stmt = connection.createStatement();
                System.out.println("Соединение с базой данных установлено");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public void stop() {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Соединение с базой данных закрыто");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public List<Entry> getArrayWithUsers(){
            try {
                ResultSet result = stmt.executeQuery("SELECT * FROM users;");
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
                e.printStackTrace();
            }
            return null;
        }
}



