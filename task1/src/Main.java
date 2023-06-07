public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int first_num = 1;
        do{
            System.out.print(first_num);
            first_num = (first_num + m - 2) % n +1;
        }
        while (first_num!=1);


    }
}