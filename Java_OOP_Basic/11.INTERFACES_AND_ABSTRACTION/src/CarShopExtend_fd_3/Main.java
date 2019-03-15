package CarShopExtend_fd_3;

public class Main {
    public static void main(String[] args) {

        Sellable seat = new Seat("Spain", "Leon",110, "Gray", 1111.1);
        Rentable audi = new Audi(countryProduced, "A4", "Blue",1250, 25, 222221.1);

        System.out.println(seat);
        System.out.println(audi);

    }
}
