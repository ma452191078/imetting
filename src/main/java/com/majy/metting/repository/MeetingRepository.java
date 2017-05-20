package com.majy.metting.repository;

import com.majy.metting.model.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by majingyuan on 2016/12/19.
 * Meeting数据库处理
 */
public interface MeetingRepository extends JpaRepository<Meeting, String> {

    public List<Meeting> findByMeetingName(String meetingName);

    public Page<Meeting> findByMeetingName(Pageable pageable, String meetingName);

//    @Query(value = "select a.meetingId from meeting a where a.meetingName = ?1 and a.startDate between ?2 and ?3")
//    public List<Meeting> findMeetingList(String meetingName, Date startDate, Date endDate);
//
//    @Query("select a from Meeting a where a.meetingName = ?1 and a.startDate between ?2 and ?3")
//    public Page<Meeting> findMeetingListPage(Pageable pageable, String meetingName, Date startDate, Date endDate);

    Page<Meeting> findAll(Specification<Meeting> specification, Pageable pageable);
}

