package app.utilities;

public class InputParser {

    public InputParser(){

    }

    public String[] splitter(String text){

        String[] splitter = text.split("\\s+");

        return splitter;
    }


}
