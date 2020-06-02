import javax.inject.Inject;
import java.util.List;

public class ItemsService {
    @Inject
    private DataRepository repository;

    public ItemsService(DataRepository repository) {
//        this.repository = repository;
    }

    public List<String> getAll() {
        return repository.getAll();
    }

    public List<String> getAllByPattern(String pattern) {
        return repository.getAll();
    }
}
