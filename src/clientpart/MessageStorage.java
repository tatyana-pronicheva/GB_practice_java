package clientpart;
import java.io.*;
import java.util.ArrayList;

public class MessageStorage {
    final String STORAGE_DIR = System.getProperty("user.dir") + File.separator + "messageStorage";
    final int STORAGE_SIZE = 100;
    private File userStorage;

    public MessageStorage(String userId){
        new File(STORAGE_DIR).mkdirs();
        //отдельный файл с историей сообщений для каждого юзера, который зайдет с этого устройства
        userStorage = new File(STORAGE_DIR + File.separator + userId +".txt");
        try {
            userStorage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMessagesHistory(){
        ArrayList<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(userStorage))) {
            String str;
            while ((str = reader.readLine()) != null) {
                history.add(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }

    public void saveMessagesHistory(String[] messages){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userStorage))) {
            String[] history;
            if (messages.length>STORAGE_SIZE){
                history = new String[STORAGE_SIZE];
                System.arraycopy(messages,messages.length-STORAGE_SIZE,history,0,STORAGE_SIZE);
            }else{
                history = messages;
            }
            for (int i = 0; i < history.length; i++) {
                writer.write(history[i]+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
