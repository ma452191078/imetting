package com.majy.metting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by majingyuan on 2016/12/20.
 * 座次类
 */

@Entity
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

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatRoom() {
        return seatRoom;
    }

    public void setSeatRoom(String seatRoom) {
        this.seatRoom = seatRoom;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }

    public String getSeatUser() {
        return seatUser;
    }

    public void setSeatUser(String seatUser) {
        this.seatUser = seatUser;
    }

    public String getSeatDw() {
        return seatDw;
    }

    public void setSeatDw(String seatDW) {
        this.seatDw = seatDW;
    }

    public String getSeatKs() {
        return seatKs;
    }

    public void setSeatKs(String seatKS) {
        this.seatKs = seatKS;
    }

    public String getSeatToken() {
        return seatToken;
    }

    public void setSeatToken(String seatToken) {
        this.seatToken = seatToken;
    }
}
