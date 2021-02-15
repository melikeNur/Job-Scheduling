
//package queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author melikenur
 * @since 8.12.2020
 */
public class Config {

    public static String jobName;
    public static int ArrivalTime;
    public static int ExecutionTime;
    public static LinkedList<Job> Jobs = new LinkedList<>();
    static String path;
    public Config(String path) {
        this.path = path;
    }
    
    public static LinkedList config() throws FileNotFoundException, IOException {
       File file = new File(path); 
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while((st = br.readLine()) != null){  
        String[] list = st.split(" ,");
        jobName = list[0];
        ArrivalTime = Integer.parseInt(list[1]);
        ExecutionTime = Integer.parseInt(list[2]);
        Jobs.add(new Job(jobName,ArrivalTime,ExecutionTime));
      
        }        
        return Jobs;
        

       
    }
}
    


