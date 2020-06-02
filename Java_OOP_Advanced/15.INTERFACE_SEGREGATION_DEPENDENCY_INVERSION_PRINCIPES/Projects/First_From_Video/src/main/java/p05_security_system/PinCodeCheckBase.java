package p05_security_system;

public class PinCodeCheckBase extends BaseSecurityCheck {
    public PinCodeCheckBase(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        int pin = super.getSecurityUI().requestPinCode();
        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }
}
