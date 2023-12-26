package com.example.demo.repos;

import com.example.demo.models.ThesisOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThesisOfferRepository extends JpaRepository<ThesisOffer, Long> {

}
