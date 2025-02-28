package com.example.dream_house.model;

/**
 * 功能描述
 *
 * @author l00845811
 * @since 2025-02-20
 */
public enum CandidateStatus {
    LOCKED("锁定简历"),
    SEND_TEST("发送机试"),
    // ...其他枚举值
    ONBOARD("已到岗");

    private final String description;

    CandidateStatus(String description) {
        this.description = description;
    }
}