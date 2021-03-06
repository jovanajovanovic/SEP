package rs.ac.uns.ftn.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.bank.model.Card;

import java.time.LocalDate;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByPan(String pan);
    Card findByCvv(String cvv);
    Card findByCardholderName(String cardholderName);
    Card findByExpiryDate(LocalDate expiryDate);
}
