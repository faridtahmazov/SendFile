import java.io.*;
import java.net.Socket;
import java.net.SocketException;
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
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the received file name: ");
            String fileName = scanner.nextLine();
            String format = dis.readUTF();
            byte[] bytes = messageServer(dis);

            FileUtility.writeBytes("C:\\Users\\TahmazovFarid\\Desktop\\" + fileName + "." + format, bytes);

            System.out.println("✓ Received successfuly!");

            dis.close();
            dos.close();

        }catch (SocketException se){
            System.out.println("Socket error!");
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
