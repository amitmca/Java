import java.io.*;
import java.util.*;

public class reverseString {
    public static void main(String[] args) {
        String input="";
		int n,r=0,i=0,j=0;
        System.out.println("Enter the input string");
			
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
           /* char[] try1= input.toCharArray();
            for (int i=try1.length-1;i>=0;i--)
            System.out.print(try1[i]);*/
			n=Integer.parseInt(input);
						 
			 while(n > 0)
			 {
			 r=n%10;
			 if(r%2 == 0)
				i++;
			  else 
				j++;
			 n=n/10;
			 }
			
			 if(i%2==0 && j%2!=0) 
				System.out.print("YES");
			 else	
				System.out.print("NO");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}