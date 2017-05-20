package com.majy.metting.controller;

import com.majy.metting.model.Meeting;
import com.majy.metting.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by majingyuan on 2016/12/19.
 * Meeting控制器
 */

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    MeetingRepository meetingRepository;

    /**
     * 查询所有会议
     * @return
     */
    @GetMapping("/getAllMeetings")
    public Page<Meeting> getAllMeeting(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "2") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        Pageable pageable = new PageRequest(page,size,sort);

        return meetingRepository.findAll(pageable);
    }

    /**
     * 根据会议ID进行查询
     * @param meetingId
     * @return
     */
    @PostMapping("/getMeetingInfo")
    public Meeting getMeetingInfo(@RequestParam("meetingId") String meetingId){
        return meetingRepository.findOne(meetingId);
    }

    /**
     * 根据会议名称进行查询
     * @param meetingName
     * @return
     */
    @PostMapping("/getMeetingListByName")
    public Page<Meeting> getMeetingListByName(@RequestParam("meetingName") String meetingName,
                                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "15") Integer size){

        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        Pageable pageable = new PageRequest(page,size,sort);
        return meetingRepository.findByMeetingName(pageable,meetingName);
    }


    /**
     * 根据查询条件进行查询
     * @param meetingName
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping("/getMeetingList")
    public List<Meeting> getMeetingList(@RequestParam("meetingName") String meetingName,
                                        @RequestParam("startDate") Date startDate,
                                        @RequestParam("endDate") Date endDate){


        List<Meeting> list = meetingRepository.findAll();
        return list;
    }

    /**
     * 根据查询条件进行查询
     * @param meetingName
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping("/getMeetingListPage")
    public Page<Meeting> getMeetingListPage(@RequestParam("meetingName") String meetingName,
                                        @RequestParam("startDate") Date startDate,
                                        @RequestParam("endDate") Date endDate,
                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                        @RequestParam(value = "size", defaultValue = "15") Integer size){

        if (endDate == null){
            endDate = new Date();
        }
        Date finalEndDate = endDate;

        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        Pageable pageable = new PageRequest(page,size,sort);


        Specification<Meeting> specification = new Specification<Meeting>() {
            @Override
            public Predicate toPredicate(Root<Meeting> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate pDate = null;
                Predicate pName = null;

                if (meetingName != null){
                    pName = criteriaBuilder.equal(root.get("meetingName"), meetingName);
                }

                if (startDate != null){
                    pDate = criteriaBuilder.between(root.get("startDate"), startDate, finalEndDate);
                }
                criteriaQuery.where(pName, pDate);

                return null;
            }
        };

        Page<Meeting> list = meetingRepository.findAll(specification,pageable);
        //Page<Meeting> list = meetingRepository.findMeetingListPage(pageable ,meetingName, startDate, endDate);
        return list;
    }

    @PostMapping("/saveMeeting")
    public Meeting saveMeeting(@RequestParam("meetingName") String meetingName,
                               @RequestParam("meetingRemark") String meetingRemark,
                               @RequestParam("startDate") String startDate,
                               @RequestParam("endDate") String endDate,
                               @RequestParam("creator") Integer creator){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Meeting result = new Meeting();

        try {
            UUID uid = UUID.randomUUID();
            Meeting meeting = new Meeting();
            meeting.setMeetingId(uid.toString());
            meeting.setMeetingName(meetingName);
            meeting.setMeetingRemark(meetingRemark);
            meeting.setStartDate(format.parse(startDate));
            meeting.setEndDate(format.parse(endDate));
            meeting.setCreator(creator);
            meeting.setCreateDate(new Date());

            result = meetingRepository.save(meeting);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

}
