import java.io.*;
import java.util.ArrayList;

public class MailHandler {
    public static void serialize(Object mailList){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Mails.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(mailList);
            objectOutputStream.close();
            fileOutputStream.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static Object deserialize() throws IOException {
        ArrayList<Object> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("Mails.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<Object>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
            FileOutputStream fileOutputStream = new FileOutputStream("Mails.ser");
            fileOutputStream.close();
        }
        return list;
    }

}
