import java.util.Scanner;

public class FormattingNumbers_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstN = input.nextInt();
        float secondN =input.nextFloat();
        float thirdN =input.nextFloat();
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
        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|",firstN, sb.toString(),secondN,thirdN);

    }
}
