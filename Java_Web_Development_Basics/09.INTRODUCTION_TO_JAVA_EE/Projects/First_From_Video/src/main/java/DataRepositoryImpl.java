import java.util.ArrayList;
import java.util.List;

public class DataRepositoryImpl implements DataRepository {

    @Override
    public List<String> getAll() {
        List<String> items = new ArrayList<String>();
        items.add("John");
        items.add("Pesho");
        items.add("Gosho");
        items.add("Pena");

        return items;
    }
}
