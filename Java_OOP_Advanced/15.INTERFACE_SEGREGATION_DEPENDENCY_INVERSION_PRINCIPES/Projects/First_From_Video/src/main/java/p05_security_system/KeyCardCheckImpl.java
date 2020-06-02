package p05_security_system;

public class KeyCardCheckImpl extends BaseSecurityCheck implements KeyCardCheck{

    public KeyCardCheckImpl(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        String code = super.getSecurityUI().requestKeyCard();

        return isValid(code);
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public String requestKeyCard() {
        return null;
    }
}
