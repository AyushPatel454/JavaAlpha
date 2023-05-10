/*
 * ===> Question: 4: Job Sequencing Problem
 * Given an array of jobs where every job has a deadline and profit.
 * If the job is finished before the deadline. It is also given that every
 * job take a single unit of time, so the minimum possible deadline for any
 * job can be schedule at a time.
 * 
 * JOB A = 4 , 20
 * JOB B = 1 , 10       Answer: C, A (Highest profit 40+20 = 60)
 * JOB C = 1 , 40
 * JOB D = 1 , 30
 * 
 * Here, required Highest profit so sortin is based on Profit.
 */

import java.util.*;

public class G_JobSequencing {
    static class Job {
        int deadLine;
        int profit;
        int id;

        // Constructor for assing ID, DEADLINE, PROFIT
        public Job(int i, int d, int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        // {deadline, profit}
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        // store Job objects in ArrayList.
        ArrayList<Job> jobs = new ArrayList<>();

        // Create objects of Job class & store all objects in ArrayList.
        for(int i = 0; i<jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
            /*
             * {id, deadline, profit}
             * {0, 4, 20}
             * {1, 1, 10}
             * {2, 1, 40}
             * {3, 1, 30}
             */
        }

        // Sort objects in descending order which is store in ArrayList.
        // Sort objects based on profit.
        Collections.sort(jobs, (obj1 , obj2) -> obj2.profit-obj1.profit);   // obj2.dataMember - obj1.dataMember ---> Descending order.
                                                                             // obj1.dataMember - obj2.dataMember ---> Ascending order.
        /*  {id, deadline, profit}
            {2, 1, 40}
            {3, 1, 30}
            {0, 4, 20}
            {1, 1, 10}
        */                                                                     
        // Storing sequece of Job is choose. --> (ID of job)
        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0; // Initialy time is 0
        int highestProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadLine > time) {
                seq.add(curr.id);
                highestProfit += curr.profit;
                time++;
            }
        }

        // Prting seq
        System.out.println("Max jobs = "+seq.size());
        System.out.println("Highest profit = "+highestProfit);
        System.out.print("ID: ");
        for(int i=0; i<seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
    }
}