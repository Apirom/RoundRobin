package com.company.utils;

public class Process {
    private String pName;
    private int burstTime;
    private int arrivalTime =0;
    private int waitTime = 0;
    private int responeTime;
    private boolean isRspone= false;
    private int turnaroundTime;
    private int oldBurstTime;

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getOldBurstTime() {
        return oldBurstTime;
    }

    public void setOldBurstTime(int oldBurstTime) {
        this.oldBurstTime = oldBurstTime;
    }

    public int getResponeTime() {
        return responeTime;
    }

    public void setResponeTime(int responeTime) {
        this.responeTime = responeTime;
    }

    public boolean isRspone() {
        return isRspone;
    }

    public void setRspone(boolean rspone) {
        isRspone = rspone;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Process() {

    }
}
