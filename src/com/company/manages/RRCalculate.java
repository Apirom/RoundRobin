package com.company.manages;

import com.company.utils.Process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class RRCalculate {

    public RRCalculate() {
    }

    public void Calculate(ArrayList<Process> processes, int quantum){
        ArrayList<Process> workingList = new ArrayList<>();
        int size = processes.size();
        int currentTime =0;
        int sumWaitTime=0;
        int countQuantum=0;
        do {
            for (Process p :processes) {
                if (currentTime ==  p.getArrivalTime()){
                    workingList.add(p);
                }
            }
            if (!workingList.isEmpty()) {
                workingList.get(0).setBurstTime(workingList.get(0).getBurstTime() - 1);
                if (!workingList.get(0).isRspone()){
                    workingList.get(0).setResponeTime(currentTime-workingList.get(0).getArrivalTime());
                    workingList.get(0).setRspone(true);
                }
                if (countQuantum == quantum && workingList.get(0).getBurstTime() != 0){
                    Process q = workingList.get(0);
                    workingList.remove(0);
                    workingList.add(q);
                    countQuantum =0;
                }else {
                    countQuantum++;
                }
                for (Process p : workingList){
                    if(p!= workingList.get(0)){
                        p.setWaitTime(p.getWaitTime()+1);
                    }
                }
            }

            if(!workingList.isEmpty() && workingList.get(0).getBurstTime() == 0){
                workingList.get(0).setTurnaroundTime(workingList.get(0).getWaitTime() + workingList.get(0).getOldBurstTime());
                System.out.printf("%10s Waiting Time: %5d Respone Time : %5d Turnaround Time : %5d \n",workingList.get(0).getpName(),workingList.get(0).getWaitTime(),
                        workingList.get(0).getResponeTime(),workingList.get(0).getTurnaroundTime());
                sumWaitTime += workingList.get(0).getWaitTime();
                workingList.remove(workingList.get(0));
                size--;
                countQuantum=0;
            }
            currentTime++;
        }while (size != 0);
        float avg = sumWaitTime/processes.size();
        System.out.println("Avgerage of Waiting Time :" + avg);
    }
}
