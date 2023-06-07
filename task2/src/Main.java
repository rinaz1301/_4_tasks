import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new BufferedReader(new FileReader(args[0])));
        Scanner s1 = new Scanner(new BufferedReader(new FileReader(args[1])));

        float x0=s.nextInt();
        float y0=s.nextInt();
        float r=s.nextInt();
        int i=0;
        while(s1.hasNextLine()){
            float x1 = s1.nextInt();
            float y1 = s1.nextInt();
            if( Math.pow((x1-x0),2)+Math.pow((y1-y0),2)==Math.pow(r,2)) System.out.println("0");
            if( Math.pow((x1-x0),2)+Math.pow((y1-y0),2)<Math.pow(r,2)) System.out.println("1");
            if( Math.pow((x1-x0),2)+Math.pow((y1-y0),2)>Math.pow(r,2)) System.out.println("2");
            i++;
        }


    }
}