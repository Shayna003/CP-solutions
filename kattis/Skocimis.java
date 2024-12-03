import java.util.Scanner;

class Kangaroos {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (b - a > c - b) {
                System.out.println(b - a - 1);
            } else {
                System.out.println(c - b - 1);
            }
        }
    }
}
