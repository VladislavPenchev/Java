package p05_security_system;

public abstract class BaseSecurityCheck implements SecurityCheck{

    private SecurityUI securityUI;

    public BaseSecurityCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    public SecurityUI getSecurityUI() {
        return securityUI;
    }
}
