import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new BufferedReader(new FileReader(args[0])));
        ArrayList<Integer> nums = new ArrayList<>();
        while (s.hasNextLine()){
            nums.add(s.nextInt());
        }

        Collections.sort(nums);
        int median = Math.round(nums.size()/2);
        int result = 0;
        for(int num : nums){
            result += Math.abs(num-nums.get(median));
        }
        System.out.println(result);
    }
}