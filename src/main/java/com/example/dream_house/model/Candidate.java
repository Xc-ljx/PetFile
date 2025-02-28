package com.example.dream_house.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author l00845811
 * @since 2025-02-20
 */
@Data
public class Candidate {
    private Long id;
    private String name;
    private Integer age;
    private String idNumber;
    private String university;
    private String targetPosition;
    private String recommender;
    private String phone;
    private String wechat;
    private CandidateStatus status;
    private String remark;
    private LocalDateTime createTime;
}