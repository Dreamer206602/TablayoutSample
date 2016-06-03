package com.mx.tablayoutsample.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hww on 2016/6/3.
 */
public class QuestionInfo implements Serializable{
    /** 题目id */
    private String mId = "";
    /** 题目 */
    private String mQuestion = "";
    /** 正确答案id */
    private String mCorrectAnswerId = "";
    /** 答案list */
    private ArrayList<AnswerInfo> mAnswerList = new ArrayList<>();

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getCorrectAnswerId() {
        return mCorrectAnswerId;
    }

    public void setCorrectAnswerId(String mCorrectAnswerId) {
        this.mCorrectAnswerId = mCorrectAnswerId;
    }

    public ArrayList<AnswerInfo> getAnswerList() {
        return mAnswerList;
    }

    public void setAnswerList(ArrayList<AnswerInfo> mAnswerList) {
        this.mAnswerList = mAnswerList;
    }
}
