package CodeChef_JAN231D;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class FarFromOrigin {
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
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        double distance1 = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
        double distance2 = Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2));
        if(distance1 == distance2) {
            System.out.println("EQUAL");
        } else if (distance1 > distance2) {
            System.out.println("ALEX");
        } else if (distance1 < distance2) {
            System.out.println("BOB");
        }
    }
}
