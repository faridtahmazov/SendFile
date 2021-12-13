import java.util.Scanner;

public class TargetAddress {
    String[] arr;
    String pai;

    private TargetAddress(){}

    private static TargetAddress targetAddress = null;

    public static TargetAddress getInstance(){
        if(targetAddress==null){
            targetAddress = new TargetAddress();
        }
        return targetAddress;
    }

    private String[] portAndIp(){
        if (pai == null){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter ip:port is target: ");
            pai = scanner.nextLine();
            arr = pai.split(":");
        }
        return arr;
    }

    public String targetIp(){
        String ip = portAndIp()[0];
        return ip;
    }

    public Integer targetPort(){
        Integer port = Integer.parseInt(portAndIp()[1]);
        return port;
    }



}
