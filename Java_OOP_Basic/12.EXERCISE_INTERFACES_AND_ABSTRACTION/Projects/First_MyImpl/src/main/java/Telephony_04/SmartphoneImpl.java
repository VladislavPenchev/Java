package Telephony_04;


public class SmartphoneImpl implements Smartphone{

    @Override
    public String browser(String email) {
        if(email.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        return String.format("Browsing: %s", email);
    }

    @Override
    public String calling(String phoneNumber) {
        if(!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid number!");
        }
        return String.format("Calling... %s", phoneNumber);
    }
}
