package com.itsqmet.app_gym_web2.repository;

import com.itsqmet.app_gym_web2.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion,Long> {
}
