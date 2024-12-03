import java.util.Scanner;

class Reverse {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();

            int c = reverse(a);
            int d = reverse(b);

            System.out.println(c > d ? c : d);
        }
    }

    private static int reverse(int x) {
        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }
}
