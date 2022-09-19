package com.algaworks.algalog.algalogapi.domain.repository;

import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
