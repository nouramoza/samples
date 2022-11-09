package com.blu.bankservice.card.repository;

import com.blu.bankservice.card.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    public CardEntity findByCardNumber(String cardNumber);

}
