package com.example.daily;

/**
 * Created by ad06-wjf on 2016/10/25.
 */

public class DailyInfo {

    private Long id;

    private String name;

    private String createId;

    private String createDate;

    private String shouldFinishedWork;

    private String haveFinishedWork;

    private String unfinishedReason;

    private String questionAndReason;

    private String nextDayPlan;

    public DailyInfo(String shouldFinishedWork,
                     String haveFinishedWork,
                     String unfinishedReason,
                     String questionAndReason,
                     String nextDayPlan) {
        this.shouldFinishedWork = shouldFinishedWork;
        this.haveFinishedWork = haveFinishedWork;
        this.unfinishedReason = unfinishedReason;
        this.questionAndReason = questionAndReason;
        this.nextDayPlan = nextDayPlan;
    }

    public String getShouldFinishedWork() {
        return shouldFinishedWork;
    }

    public void setShouldFinishedWork(String shouldFinishedWork) {
        this.shouldFinishedWork = shouldFinishedWork;
    }

    public String getHaveFinishedWork() {
        return haveFinishedWork;
    }

    public void setHaveFinishedWork(String haveFinishedWork) {
        this.haveFinishedWork = haveFinishedWork;
    }

    public String getUnfinishedReason() {
        return unfinishedReason;
    }

    public void setUnfinishedReason(String unfinishedReason) {
        this.unfinishedReason = unfinishedReason;
    }

    public String getQuestionAndReason() {
        return questionAndReason;
    }

    public void setQuestionAndReason(String questionAndReason) {
        this.questionAndReason = questionAndReason;
    }

    public String getNextDayPlan() {
        return nextDayPlan;
    }

    public void setNextDayPlan(String nextDayPlan) {
        this.nextDayPlan = nextDayPlan;
    }
}
