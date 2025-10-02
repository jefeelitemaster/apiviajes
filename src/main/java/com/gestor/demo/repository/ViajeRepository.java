package com.gestor.demo.repository;

import com.gestor.demo.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    //obtener todos los viajes que haya, es algo común jpa ya lo tiene implementado internamente

}
