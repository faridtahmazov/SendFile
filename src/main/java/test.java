import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
      File file = new File("C:\\Users\\TahmazovFarid\\Desktop\\foo.txt");
      if (file.exists()){
          System.out.println("Fayl artığ var");
      }else{
          try{
              file.createNewFile();
              System.out.println("Fayl yaradıldı!");
          }catch (IOException e){
              System.out.println("Fayl yaradılarkən bir xəta oldu!\nXəta mesajı: " + e.getMessage());
          }
      }
      File changedName = new File("C:\\Users\\TahmazovFarid\\Desktop\\changed.txt");
      file.renameTo(changedName);
      changedName.delete();
      file.delete();
        System.out.println("Fayl silindi!");

    }
}
