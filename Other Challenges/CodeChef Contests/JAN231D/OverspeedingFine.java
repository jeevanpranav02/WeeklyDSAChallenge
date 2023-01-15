package CodeChef_JAN231D;

import java.util.Scanner;

public class OverspeedingFine {
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
        if(x >= 1 && x <= 70) {
            System.out.println(0);
        } else if(x > 70 && x <= 100) {
            System.out.println(500);
        } else if(x > 100 && x <= 200){
            System.out.println(2000);
        }
    }
}
