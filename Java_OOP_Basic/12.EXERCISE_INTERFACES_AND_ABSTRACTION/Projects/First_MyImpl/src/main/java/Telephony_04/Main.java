package Telephony_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = bufferedReader.readLine().split("\\s+");
        String[] webSites = bufferedReader.readLine().split("\\s+");

        Smartphone smartphone = new SmartphoneImpl();

        Arrays.stream(numbers).forEach(phoneNumber -> {
            try {
                System.out.println(smartphone.calling(phoneNumber));
            }catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });

        Arrays.stream(webSites).forEach(phoneNumber -> {
            try {
                System.out.println(smartphone.browser(phoneNumber));
            }catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });
    }
}
