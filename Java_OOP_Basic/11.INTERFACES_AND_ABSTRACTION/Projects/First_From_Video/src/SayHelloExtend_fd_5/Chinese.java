package SayHelloExtend_fd_5;

public class Chinese extends BasePerson implements Person {


    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Ni hao";
    }
}
