import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //TANIMLAMALAR

        //İstifadəçi məlumatı
        FormPerson.fullData();
        String name = FormPerson.name;

        //Server üçün
        ServerSocket server;
        Socket client;

        //İnput almaq üçün
        Scanner scanner;

        //Giriş-çıxış üçün
        DataOutputStream dos;
        DataInputStream dis;

        //Dəyişənlər üçün
        Integer port = User.port();

        try{
            //Port açmaq və əlaqələndirmək
            server = new ServerSocket(port);
            System.out.println("Waiting for connection...");
            client = server.accept();
            System.out.println("Connected is successfuly!");
            System.out.println(Introduction.brace);
           // int menu = Introduction.menu();

            //Giriş əməliyyatları
            dos = new DataOutputStream(client.getOutputStream());
            //Çıxış əməliyyatları
            dis = new DataInputStream(client.getInputStream());

            //File oxuma əmrləri
            System.out.print("Enter the file way: ");
            scanner = new Scanner(System.in);
            //  C:\Users\TahmazovFarid\Pictures\Me\FaridTahmazov.jpg

            byte[] array = FileUtility.readBytes(scanner.nextLine());
            dos.writeInt(array.length);
            dos.write(array);
            System.out.println("Sended successfuly ✓");

            dos.close();
            dis.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
