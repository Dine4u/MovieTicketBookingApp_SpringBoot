package org.example.designmovieticketbookingtool.repository;

import jakarta.persistence.LockModeType;
import org.example.designmovieticketbookingtool.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
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

//    @Query(" SELECT id FROM showseats WHERE id IN (:showSeats) AND show=:show AND seatStatus='Available'")
//    @Lock(LockModeType.PESSIMISTIC_WRITE) //This makes sure select
//    List<ShowSeat> getAllAvailableSeatsForGivenShow(@Param("showSeats") List<ShowSeat> showSeats,@Param("show") Show show);


    //2nd approach - by using SpringDataJPA inbuilt method name functionality - @Lock used FOR UPDATE
    @Lock(LockModeType.PESSIMISTIC_WRITE) //This makes sure SELECT query runs with FOR UPDATE
//    List<ShowSeat> findShowSeatsByIdInAndSeatStatus_AvailableAndShow(int showid, List<Integer> showSeatIDs);

    List<ShowSeat> findShowSeatsByIdIsInAndShowIdAndSeatStatus_Available(List<Integer> showSeatIDs, int showid);
}
