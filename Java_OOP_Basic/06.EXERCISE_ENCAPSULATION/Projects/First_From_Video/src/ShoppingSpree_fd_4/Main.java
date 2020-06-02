package ShoppingSpree_fd_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        String[] inputArgs = reader.readLine().split(";");

        try{
            for (String inputArg : inputArgs) {
                String[] personArgs = inputArg.split("=");

                String name = personArgs[0];
                double money  = Double.parseDouble(personArgs[1]);

                Person person = new Person(name,money);

                persons.add(person);
            }

            inputArgs = null;
            inputArgs = reader.readLine().split(";");

            for (String inputArg : inputArgs) {
                String[] productArgs = inputArg.split("=");

                String name = productArgs[0];
                double cost  = Double.parseDouble(productArgs[1]);

                Product product = new Product(name,cost);

                products.add(product);
            }

            String line;
            while (!"END".equals(line = reader.readLine())) {
                String[] temp = line.split("\\s+");

                String personName = temp[0];
                String productName = temp[1];

                persons.stream()
                        .filter(pn -> pn.getName().equals(personName))
                        .forEach(pn -> {
                            //check is afford to buy
                            Product pr =  products.stream()
                                    .filter(v -> v.getName().equals(productName))
                                    .findFirst()
                                    .get();

                            pn.checkIsAffordToBuy(pr.getCost(), pr.getName());

                            pn.setBagOfProducts(pr);

                            System.out.println(String.format("%s bought %s",pn.getName(),pr.getName()));

                        });
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        persons.forEach(res -> System.out.println(res.toString()));

    }


}
