package com.eventus.api.repository;

import com.eventus.api.domain.PontoComercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoComercialRepository extends JpaRepository<PontoComercial, Long> {

}