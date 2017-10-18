package com.company;

import com.company.manages.RRCalculate;
import com.company.utils.Process;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    String name ="";
    int at = 0;
    int bt = 0;
    static ArrayList<Process> processes = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        init();
        System.out.printf("%1s%15s%15s\n","Process","ArrivalTime","BurstTime");
        for (Process p : processes){
            System.out.printf("%-15s%-7d%12d\n",p.getpName(),p.getArrivalTime(),p.getBurstTime());
        }
        System.out.printf("----------------------------------------\n");
        RRCalculate srtfClass = new RRCalculate();
        srtfClass.Calculate(processes,2);
    }

    static void init(){
        for(int i=0; i<100 ;i++){
            Random random = new Random(i);
            Process process = new Process();
            process.setpName("P["+(i+1)+"]");
            if(i < 60) {
                process.setArrivalTime(random.nextInt(50) + 0);
                process.setBurstTime(random.nextInt(10) + 1);
                process.setOldBurstTime(process.getBurstTime());
            }else {
                process.setArrivalTime(random.nextInt(50) + 0);
                process.setBurstTime(random.nextInt(100) + 50);
                process.setOldBurstTime(process.getBurstTime());
            }
            processes.add(process);
        }
        processes.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.getArrivalTime() == o2.getArrivalTime())
                    return Integer.valueOf(o1.getBurstTime()).compareTo(o2.getBurstTime());
                else
                    return Integer.valueOf(o1.getArrivalTime()).compareTo(o2.getArrivalTime());
            }

        });
    }
}
