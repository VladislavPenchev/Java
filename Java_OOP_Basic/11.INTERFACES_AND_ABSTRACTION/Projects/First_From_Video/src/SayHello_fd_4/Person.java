package SayHello_fd_4;

public interface Person {
    String getName();

    default  String sayHello(){
        return "Hello";
    }
}
