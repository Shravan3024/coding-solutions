import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
        
        int perimeter = 2*(l+b);
        int area = l*b;
        
        System.out.println("The required length is "+perimeter+" m");
        System.out.println("The required area of carpet is "+area+" sqm");

    }
}
