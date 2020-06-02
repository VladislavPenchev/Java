package OddAndEvenPairs_5;
import java.util.Scanner;

public class OddAndEvenPairs_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");  //1 2 3 4   //2 8 11 15 3 2
        int[] nums = new int[line.length];


        for(int i = 0; i < line.length; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        if(nums.length % 2 != 0){
            System.out.println("invalid length");
        }else{

            for(int i = 0; i < nums.length; i+=2){
                if(nums[i] % 2 == 0 && nums[i + 1] % 2 == 0){
                    System.out.printf("%d, %d -> both are even\n",nums[i],nums[i + 1]);
                }
                else if(nums[i] % 2 == 1 && nums[i + 1] % 2 == 1){
                    System.out.printf("%d, %d -> both are odd\n",nums[i],nums[i + 1]);
                }else{
                    System.out.printf("%d, %d -> different\n",nums[i],nums[i + 1]);
                }
            }
        }
    }
}
