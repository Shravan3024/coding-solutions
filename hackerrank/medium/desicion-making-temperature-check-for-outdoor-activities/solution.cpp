import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temperature = sc.nextInt();

        if (temperature > 0) {
            System.out.println("Safe for outdoor activities");
        } else {
            System.out.println("Too cold for outdoor activities");
        }

        sc.close();
    }
}
