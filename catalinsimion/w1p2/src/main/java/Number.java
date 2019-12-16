

import java.util.Scanner;

public class Number {


    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");

        n = scan.nextInt();
        scan.close();

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + "-PRIME");
            } else {
                System.out.println(i);
            }

        }

    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else {
            int m = n / 2;
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}


