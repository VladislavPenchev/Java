package realestate.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realestate.domain.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, String> {
}
