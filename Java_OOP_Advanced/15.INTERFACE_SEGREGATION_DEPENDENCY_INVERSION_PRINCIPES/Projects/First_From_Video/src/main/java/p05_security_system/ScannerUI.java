package p05_security_system;

import java.util.Scanner;

public class ScannerUI implements SecurityUI {

    private Scanner scanner;

    public ScannerUI(Scanner scanner) {
        this.scanner =scanner;
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }
}
