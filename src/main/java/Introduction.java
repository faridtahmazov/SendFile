import java.util.Scanner;

public class Introduction {
    public static String brace = "---------------";
    public static Integer menuOperation;

    public static void intro(){
        System.out.println(brace + "> File Chat <" + brace);
        String formPerson = FormPerson.fullData();
    }

//    public static int menu(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("1. Message sended" +
//                "\n2. File sended");
//        System.out.print("Choise operation: ");
//        menuOperation = scanner.nextInt();
//        return menuOperation;
//    }

//    public static void main(String[] args) {
//        int a = Introduction.menu();
//
//        if (a == 1){
//            System.out.println("Helloo");
//        }
//    }
}
