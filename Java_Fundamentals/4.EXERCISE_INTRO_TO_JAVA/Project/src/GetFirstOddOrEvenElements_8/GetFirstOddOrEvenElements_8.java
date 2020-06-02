package GetFirstOddOrEvenElements_8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetFirstOddOrEvenElements_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int[] nums = new int[numbers.length];
        String[] condition = scanner.nextLine().split(" ");
        List<Integer> resultWithEven = new ArrayList<Integer>();
        List<Integer> resultWithOdd = new ArrayList<Integer>();

        int getNumbers = Integer.parseInt(condition[1]);
        String evenOrOdd = condition[2];//.substring(0,1);


        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);

            if(nums[i] % 2 == 0){
                resultWithEven.add(nums[i]);
            }else{
                resultWithOdd.add(nums[i]);
            }

        }

        if(evenOrOdd.equals("even")){
            if(resultWithEven.size() < getNumbers){
                getNumbers = resultWithEven.size();
            }
            for(int i = 0; i < getNumbers;i++){
                System.out.printf("%d ", resultWithEven.get(i));
            }
        }else{
            if(resultWithOdd.size() < getNumbers){
                getNumbers = resultWithOdd.size();
            }
            for(int i = 0; i < getNumbers;i++){
                System.out.printf("%d ", resultWithOdd.get(i));
            }
        }
    }
}
/*
11 6 2 8 1 0
Get 8 even

 */