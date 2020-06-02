package creationals.builder_03;

public class Main {
    public static void main(String[] args) {
        Address address = Address.builder()
                .withCity("Sofia")
                .withCountry("Bulgaria")
                .build();
    }
}
