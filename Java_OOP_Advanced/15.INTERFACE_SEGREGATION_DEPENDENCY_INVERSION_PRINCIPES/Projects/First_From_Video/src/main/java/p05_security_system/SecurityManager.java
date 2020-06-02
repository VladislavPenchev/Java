package p05_security_system;

import java.io.IOException;
import java.util.Scanner;

public class SecurityManager {

    private SecurityCheck keyCardCheck;
    private SecurityCheck pinCodeCheck;

    public SecurityManager(SecurityCheck keyCardCheck, SecurityCheck pinCodeCheck) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println(keyCardCheck.validateUser());
                break;
            case 2:
                System.out.println(pinCodeCheck.validateUser());
                break;
        }
    }

}
