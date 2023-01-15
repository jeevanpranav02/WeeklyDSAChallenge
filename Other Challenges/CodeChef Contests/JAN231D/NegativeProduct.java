package CodeChef_JAN231D;

import java.util.Scanner;

public class NegativeProduct {
    public static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) throws java.lang.Exception
    {
        int t = sc.nextInt();
        while(t --> 0)
        {
            solve();
        }
    }
    static void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        if(x * y < 0 || x * z < 0 || y * z < 0) {
            System.out.println("\nYES");
        } else {
            System.out.println("\nNO");
        }
    }
}
