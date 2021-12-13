import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileWay =scanner.nextLine();

        String[] format = fileWay.split("\\.");
        if (fileWay.contains(".")){
            System.out.println("Yes!");
            for (int i=0; i<format.length; i++){
                System.out.println(i+1 + ". " + format[i]);
            }

        }
//        System.out.println("FileWay: " + fileWay);
//        System.out.println("Format: " + format);
//        System.out.println(format[0]);
    }
}
