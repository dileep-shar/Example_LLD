import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String str;
        System.out.print("This is a string:");
        str =s.nextLine();
        System.out.println(str);

        File f = new File("/home/dileep/Documents/placements/OOPS.txt");
        BufferedReader bf = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String st ;
        while((st=bf.readLine())!=null){
                sb.append(st).append("\n");
        }
        System.out.println(sb);
    }
}