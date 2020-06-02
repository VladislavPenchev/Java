package softuni.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.entities.Label;
import softuni.demo.domain.entities.Shampoo;
import softuni.demo.domain.entities.Size;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<ShampooRepository, Long> {

    //List<Shampoo> findAllByBrand(String brand);

    List<Shampoo> findAllBySizeOrderById(Size size);

    //List<Shampoo> findAllByLabel(Label label);

    //List<Shampoo> findAllByLabelAndSize(Label label, Size size);

    //List<Shampoo> findAllByLabelOrSizeOrderById(Label label, Size size);


}
