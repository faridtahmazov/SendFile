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
        String message;
        int line;
        String readData;
        Integer port = User.port();

        //File üçün
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;



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

            //Message
//            if (menu==1){
//                //Data göndərmək
//                scanner = new Scanner(System.in);
//                System.out.print(name + ": ");
//                dos.writeUTF(name + ": " + scanner.nextLine());
//                System.out.println("✓");
//
//                //Data qəbul etmək
//                message = dis.readUTF();
//                System.out.println(message);
//
//            }
            //File
                System.out.print("Enter the file way: ");
                scanner = new Scanner(System.in);
                //  C:\Users\TahmazovFarid\Pictures\Me\FaridTahmazov.jpg

                //File oxuma əmrləri
                File file = new File(scanner.nextLine());
                byte array[] = new byte[(int) file.length()];
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);

                bufferedInputStream.read(array);
                dos.writeInt(array.length);
                dos.write(array);

                System.out.println("✓");



            bufferedInputStream.close();
            dos.close();
            dis.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
