package softuni.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.realestate.domain.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
}
