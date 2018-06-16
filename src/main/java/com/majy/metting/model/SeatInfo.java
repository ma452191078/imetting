package com.majy.metting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by majingyuan on 2016/12/20.
 * 座次类
 */

@Entity
@Data
public class SeatInfo {

    @Id
    @GeneratedValue
    private Integer seatId;
    private String seatRoom;	//会场
    private String seatRow;		//行
    private String seatCol;		//列
    private String seatUser;	//姓名
    private String seatDw;		//部门
    private String seatKs;		//科室
    private String seatToken;	//微信Token

    public SeatInfo(){

    }


}
