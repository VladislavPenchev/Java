package CharacterMultiplier_7;

import java.util.Scanner;

public class Character_Multiplier_7_second {
	 public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] line = input.nextLine().split("\\s+");
		 
        char[] char1 = line[0].toCharArray();
        char[] char2 = line[1].toCharArray();

        int totalSum = 0;
        for (int i = 0; i < Math.max(char1.length, char2.length); i++)
        {
            if (i < char1.length && i < char2.length)
            {
                totalSum += char1[i] * char2[i];
            }
            else if (i < char1.length && i >= char2.length)
            {
                totalSum += char1[i];
            }
            else if (i >= char1.length && i < char2.length)
            {
                totalSum += char2[i];
            }
        }
        System.out.println(totalSum);
	}
}
