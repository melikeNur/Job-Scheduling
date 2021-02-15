
//package queue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 *
 * @author melikenur
 * @since 8.12.2020
 */
public class Queue {
    public static LinkedList<Job> timeSchedule = new LinkedList<>();
    static int currentTime = 0;
    public static String printTime(){
        String st = "";
        for(Job j: timeSchedule){
            st += j.getName() + ",";
        }
        return st;
    }

    public static void addJobs(LinkedList<Job> jobs) throws IOException{
        LinkedList<Job> Jobs = Config.config();
        for(Job j: Jobs){
            jobs.add(j);
        }
    
    }

    static Job lastArrieved(LinkedList<Job> jobs){
        int max = Integer.MIN_VALUE;
        Job maxJob = null;
        for(Job j : jobs){
            if(j.getArriivalTime() > max){
                max = j.getArriivalTime();
                maxJob = j;
            }
        }
        return maxJob;
    }


    public static void main(String[] args) throws IOException {
         Config config = new Config(args[0]);
         File state = new File("output" + ".txt");
         FileOutputStream os = new FileOutputStream(state);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
       LinkedList<Job> allJobs = new LinkedList<>();
        addJobs(allJobs);

        int maxTime = lastArrieved(allJobs).getArriivalTime();

        while(currentTime <= maxTime || !timeSchedule.isEmpty()){
            for(Job j: allJobs){
                if(j.getArriivalTime() == currentTime){
                  
                    bw.write(currentTime + " - " + printTime() + " " +  j.getName() + " enter"); 
                    bw.write("\n");
              
                    timeSchedule.add(j);


                }
            }
            timeSchedule.get(0).run();
            currentTime++;
            if(timeSchedule.get(0).getExecutionTime() == 0){
                Job j = timeSchedule.get(0);

                timeSchedule.remove(j);
                bw.write(currentTime + " - " + printTime() + " " +  j.getName() + " is terminated");   
                bw.write("\n");
                

            }

            else if(timeSchedule.get(0).getExecuted() == 100){
                Job j = timeSchedule.get(0);
                j.resetEx();
                timeSchedule.remove(timeSchedule.get(0));
                timeSchedule.add(j);
                bw.write(currentTime + " - " + printTime() + " " +  j.getName() + " is expired, remainig " + j.getExecutionTime()+ "ms");
                bw.write("\n");
            }

        }
        bw.close();

    }
}


    
      
