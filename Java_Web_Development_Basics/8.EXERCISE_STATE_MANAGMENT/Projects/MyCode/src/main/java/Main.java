import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String line = "";
        boolean flag = true;
        while(flag){

            line = input.nextLine();

            if(line.contains("Cookie: ")){

                line = line.substring(8);

                String[] lineArgs = line.split("; ");

                for(String arg : lineArgs){
                    String output = arg.replace("=", " <-> ");
                    System.out.println(output);
                }

                flag =  false;
            }

        }


        input.close();
    }
}
