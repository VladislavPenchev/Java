package CharacterMultiplier_7;
import java.util.Scanner;

public class CharacterMultiplier_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        char[] firstWord = input[0].toCharArray();
        char[] secondWord = input[1].toCharArray();
        
        long sum = 0;
        long tempSum = 0;
        
        int shorterWord = Math.min(firstWord.length,secondWord.length);
        int longestWord = Math.max(firstWord.length,secondWord.length);
        

        for (int i = 0; i < shorterWord; i++){
            tempSum=(int)firstWord[i]*(int)secondWord[i];
            sum += tempSum;
       }

        if(firstWord.length<secondWord.length){
            for (int i = shorterWord; i <= longestWord-shorterWord; i++){
                sum+=secondWord[i];
            }
        } else if (firstWord.length>secondWord.length){
            for (int i = shorterWord; i <= longestWord-shorterWord; i++){
                sum+=firstWord[i];
            }
        }

        System.out.println(sum);
        
        scanner.close();
    }
}