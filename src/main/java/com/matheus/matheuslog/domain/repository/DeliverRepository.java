package com.matheus.matheuslog.domain.repository;

import com.matheus.matheuslog.domain.model.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}
