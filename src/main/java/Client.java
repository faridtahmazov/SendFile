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

        //İnput almaq üçün
        Scanner scanner;

        //Giriş-çıxış üçün
        DataInputStream dis;
        DataOutputStream dos;

        //File üçün
        File file;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //Dəyişənlər üçün
        String message;
        String line;
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

//            if (menu==1){
//                //Data qəbul etmək (Message)
//                message = dis.readUTF();
//                System.out.println(message);
//
//                //Data göndərmək (Message)
//                scanner = new Scanner(System.in);
//                System.out.print(name + ": ");
//                dos.writeUTF(name + ": " + scanner.nextLine());
//                System.out.println("✓");
//            }
            //File
                file = new File("C:\\Users\\TahmazovFarid\\Desktop\\Farid.jpg");
                fileOutputStream = new FileOutputStream(file, false);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int msgLen = dis.readInt();
                byte[] bytes = new byte[msgLen];
                dis.readFully(bytes);
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.flush();
                System.out.println("✓");



            bufferedOutputStream.close();
            dis.close();
            dos.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
