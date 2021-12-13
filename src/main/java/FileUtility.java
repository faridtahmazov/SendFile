import java.io.*;

public class FileUtility {
    public static byte[] readBytes(String fileWay) throws IOException{
        File file = new File(fileWay);
        byte[] array = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        bis.read(array);
        bis.close();

        return array;
    }

    public static void writeBytes(String fileName, byte[] data) throws IOException{
        FileOutputStream fop = new FileOutputStream(fileName);
        BufferedOutputStream bop = new BufferedOutputStream(fop);

        bop.write(data);
        bop.flush();
        bop.close();
    }


}
