import java.util.Scanner;

class Drunk {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            char[] str = in.nextLine().toCharArray();
            char[] key = in.nextLine().toCharArray();

            for (int i = 0; i < str.length; i++) {
                if (i % 2 == 0) {
                    str[i] -= (key[i] - 65);
                    if (str[i] < 65)
                        str[i] += 26;
                } else {
                    str[i] += (key[i] - 65);
                    if (str[i] > 65 + 25)
                        str[i] -= 26;
                }
            }
            System.out.println(String.valueOf(str));
        }
    }
}