package com.mx.tablayoutsample.model;

import java.io.Serializable;

/**
 * Created by hww on 2016/6/3.
 */
public class AnswerInfo implements Serializable{
    /** 题目id */
    private String mId = "";
    /** 答案id */
    private String mAnswerId = "";
    /** 答案内容描述 */
    private String mAnswerContent = "";
    /** 是否选中 */
    private boolean bSelected = false;
    /** 是否是选中的答案 */
    private boolean bAnswer = true;

    public AnswerInfo(){}

    public AnswerInfo(String id, String answerId, String answerContent) {
        setId(id);
        setAnswerId(answerId);
        setAnswerContent(answerContent);
        setSelected(false);
        setAnswer(false);
    }

    public AnswerInfo(String id, String answerId, String answerContent, boolean selected) {
        setId(id);
        setAnswerId(answerId);
        setAnswerContent(answerContent);
        setSelected(selected);
        setAnswer(false);
    }

    public AnswerInfo(String id, String answerId, String answerContent, boolean selected, boolean answer) {
        setId(id);
        setAnswerId(answerId);
        setAnswerContent(answerContent);
        setSelected(selected);
        setAnswer(answer);
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getAnswerId() {
        return mAnswerId;
    }

    public void setAnswerId(String mAnswerId) {
        this.mAnswerId = mAnswerId;
    }

    public String getAnswerContent() {
        return mAnswerContent;
    }

    public void setAnswerContent(String mAnswerContent) {
        this.mAnswerContent = mAnswerContent;
    }

    public boolean isSelected() {
        return bSelected;
    }

    public void setSelected(boolean bSelected) {
        this.bSelected = bSelected;
    }

    public boolean isAnswer() {
        return bAnswer;
    }

    public void setAnswer(boolean bAnswer) {
        this.bAnswer = bAnswer;
    }
}
