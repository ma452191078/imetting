package com.majy.metting.controller;

import com.majy.metting.model.SeatInfo;
import com.majy.metting.repository.SeatInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by majingyuan on 2016/12/20.
 *
 * 座位信息查询
 */
@RestController
@RequestMapping("/seatInfo")
public class SeatInfoController {

    @Autowired
    SeatInfoRepository seatInfoRepository;

    /**
     * 查询所有座次列表
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/getAllSeat")
    public Page<SeatInfo> getAllSeat(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "2") Integer size){

        Pageable pageable = new PageRequest(page,size);
        return seatInfoRepository.findAll(pageable);
    }

    /**
     * 根据ID查询座次信息
     * @param id
     * @return
     */
    @PostMapping("/getSeatInfoById")
    public SeatInfo getSeatInfoById(@RequestParam("id") Integer id){
        return seatInfoRepository.findOne(id);
    }

    /**
     * 根据人名查询座次信息
     * @param seatUser
     * @return
     */
    @PostMapping("/getSeatInfoByUser")
    public Page<SeatInfo> getSeatInfoByUser(@RequestParam("seatUser") String seatUser,
                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "5") Integer size){
        Pageable pageable = new PageRequest(page,size);
        List<SeatInfo> list = seatInfoRepository.findBySeatUser(seatUser);
        Page<SeatInfo> seatInfos = seatInfoRepository.findBySeatUser(seatUser, pageable);
        return seatInfos;
    }

    /**
     * 根据人名和单位名查询座次信息
     * @param seatUser  人名
     * @param seatDw    单位
     * @return
     */
    @PostMapping("/getSeatInfoByUserDw")
    public List<SeatInfo> getSeatInfoByUser(@RequestParam("seatUser") String seatUser,
                                            @RequestParam("seatDw") String seatDw){
        return seatInfoRepository.findBySeatUserAndSeatDw(seatUser, seatDw);
    }
}
