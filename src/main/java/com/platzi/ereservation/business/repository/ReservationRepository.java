package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("select r from Reservation r where r.checkInDate =:checkInDate and r.checkOutDate =:checkOutDate")
    public List<Reservation> find(@Param("checkInDate") Date checkInDate, @Param("checkOutDate") Date checkOutDate);
}
