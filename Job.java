
//package queue;

/**
 *
 * @author melikenur
 * @since 8.12.2020
 */


public class Job {
    String name;
    int arrivalTime;
    int executionTime;
    int executed;

    public Job(String name, int arrivalTime, int executionTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.executed = 0;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getExecuted(){
        return executed;
    }

    public void resetEx(){
        this.executed = 0;
    }

    public void run(){
        this.executed++;
        this.executionTime--;
    }

    public int getArriivalTime() {
        return arrivalTime;
    }


    public int getExecutionTime() {
        return executionTime;
    }

  
}
