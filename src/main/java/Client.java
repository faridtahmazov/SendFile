import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //TANIMLAMALAR

        //İstifadəçi məlumatı
        FormPerson.fullData();
        String name = FormPerson.name;

        //Client üçün
        Socket server;

        //Giriş-çıxış üçün
        DataInputStream dis;
        DataOutputStream dos;

        //Dəyişənlər üçün
        String ip = User.ip();
        Integer port = User.port();

        try{
            //Porta qoşulmaq
            server = new Socket(ip, port);
            System.out.println("Connected is successfuly!");
            System.out.println(Introduction.brace);
            //int menu = Introduction.menu();

            //Giriş əməliyyatları
            dis = new DataInputStream(server.getInputStream());
            //Çıxış əməliyyatları
            dos = new DataOutputStream(server.getOutputStream());

            //File
            byte[] bytes = messageServer(dis);
            FileUtility.writeBytes("C:\\Users\\TahmazovFarid\\Desktop\\Farid.jpg", bytes);

            System.out.println("✓");

            dis.close();
            dos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static byte[] messageServer(DataInputStream dis) throws IOException{
        int msgLen = dis.readInt();
        byte[] bytes = new byte[msgLen];
        dis.readFully(bytes);

        return bytes;
    }
}
