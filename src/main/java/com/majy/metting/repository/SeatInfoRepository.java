package com.majy.metting.repository;

import com.majy.metting.model.SeatInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by majingyuan on 2016/12/20.
 *
 */
public interface SeatInfoRepository extends JpaRepository<SeatInfo, Integer> {

//    public List<SeatInfo> findBySeatUser(String seatUser);

    public Page<SeatInfo> findBySeatUser(String seatUser, Pageable pageable);

    public List<SeatInfo> findBySeatUserAndSeatDw(String seatUser, String SeatDw);

}
