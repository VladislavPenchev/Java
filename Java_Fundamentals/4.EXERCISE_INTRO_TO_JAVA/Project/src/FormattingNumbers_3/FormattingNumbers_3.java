package FormattingNumbers_3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//judge 80%

public class FormattingNumbers_3 {

    public static void main(String[] args) {
    	
        Scanner input = new Scanner(System.in);
        
        int firstN = input.nextInt();
        float secondN =input.nextFloat();
        float thirdN =input.nextFloat();
        
        //decimal to hex
        char[] hexAsCharArray = Integer.toHexString(firstN).toCharArray();
        
        List<String> listWithHexChars = new ArrayList<>();
        
        for(char element : hexAsCharArray) {
        	if(element != 0) {
        		listWithHexChars.add(String.valueOf(element));
        	}
        }
        
        String result = "";
        
        for(String el : listWithHexChars) {
        	result += el;
        }
        
        result = result.toUpperCase();
        
        //decimal to binary
        String aBinary = Integer.toString(firstN, 2);
        StringBuilder sb = new StringBuilder(aBinary);
        sb.reverse();
        while(sb.length()<12){
            sb.append("0");
        }
        sb.reverse();
        if(sb.length()>10){
            while(sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
                if(sb.length()==10){
                    break;
                }
            }
        }
        
        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|",result, sb.toString(),secondN,thirdN);

        input.close();
    }
    

}
