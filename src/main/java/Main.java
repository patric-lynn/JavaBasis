import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        int[] count = new int[group];
        String[] strings = new String[group];
        for (int i = 0; i < group; i++) {
            count[i] = in.nextInt();
            strings[i] = in.next();
        }
        for (int i = 0; i < group; i++) {
            System.out.println(strings[i]);
        }
    }
}
