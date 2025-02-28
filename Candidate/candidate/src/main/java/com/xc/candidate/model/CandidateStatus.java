
package com.xc.candidate.model;

/**
 * 功能描述
 *
 * @author l00845811
 * @since 2025-02-20
 */
public enum CandidateStatus {
    LOCKED("0", "锁定简历"),
    SEND_TEST("1", "发送机试"),
    TEST_PASS("2", "发送机试"),
    TEST_PASS2("3", "机试通过"),
    HR_PASS("4", "HR面通过"),
    TEC_INTERVIEW_PASS1("5", "技术一面通过"),
    TEC_INTERVIEW_PASS2("6", "技术二面通过"),
    BOSS_INTERVIEW_PASS("7", "主管面通过"),
    OFFER_APPROVING("8", "offer审批中"),
    OFFER_ACCEPTED("9", "已接受offer"),
    ONBOARD("10", "已到岗"),
    FAILED("-1", "流程失败");

    private final String code;

    private final String description;

    CandidateStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCode() {
        return this.code;
    }

    /**
     * getNameByCode
     *
     * @param code code
     * @return CandidateStatus
     */
    public static CandidateStatus valueOfCode(String code) {
        for (CandidateStatus status : CandidateStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}