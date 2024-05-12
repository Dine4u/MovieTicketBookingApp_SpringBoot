package org.example.designmovieticketbookingtool.repository;

import jakarta.persistence.LockModeType;
import org.example.designmovieticketbookingtool.models.SeatStatus;
import org.example.designmovieticketbookingtool.models.Show;
import org.example.designmovieticketbookingtool.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, List<Integer>> {
    //check the available seat for mentioned show
    // for this, we use below select query
    //      SELECT * FROM showseats
    //      WHERE showseatids IN (a,b,c)
    //      AND seatstatus='Available'
    //      AND showid=<x> FOR UPDATE;

    //Above query can be executed in two ways by SpringData JPA

    //1st approach - by using @Query + @Lock - @Lock used FOR UPDATE

//    @Query(value = " SELECT *  FROM showseats WHERE show_id IN (:showSeatIDs) AND show=:show AND seatStatus='Available'",nativeQuery = true)
//    @Lock(LockModeType.PESSIMISTIC_WRITE) //This makes sure SELECT query runs with FOR UPDATE
//    List<ShowSeat> getAllAvailableSeatsForGivenShow(@Param("showSeatIDs") List<Integer> showSeatIDs, @Param("show") Show show); // application working for this methods with Query


//    //2nd approach - by using SpringDataJPA inbuilt method name functionality - @Lock used FOR UPDATE
    @Lock(LockModeType.PESSIMISTIC_WRITE) //This makes sure SELECT query runs with FOR UPDATE

    List<ShowSeat> findShowSeatsByIdIsInAndShowAndSeatStatus(List<Integer> showSeatIDs, Show show,SeatStatus seatStatus);
}
