import java.util.*;

public class Finance{
    // Recursive method to calculate future value
    static double calculate(double r,double principal,int year) {
        if(year == 0){
        	return principal;  
        }
        return calculate(r,principal,year-1)*(1+r);  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initial investment
        double principal = sc.nextDouble();
        // Growth rate in percentage
        int percent = sc.nextInt();  
        // Number of years
        int year = sc.nextInt();             

        // Convert percentage to decimal
        double r = (double) percent / 100.0;   

        // Output future value
        System.out.println(calculate(r, principal, year));
    }
}
