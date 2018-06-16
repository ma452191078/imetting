package com.majy.metting.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by majingyuan on 2016/12/19.
 * 会议类
 */

@Entity
@Data
public class Meeting {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(length = 40)
    private String meetingId;

//    会议名称
    private String meetingName;

//    会议备注
    private String meetingRemark;

//    开始时间
    private Date startDate;

//    结束时间
    private Date endDate;

//    启用标识
    private Integer enableFlag;

//    创建人id
    private Integer creator;

//    创建日期
    private Date createDate;

//    评分规则
    private String meetingRole;

    public Meeting() {
    }


}
