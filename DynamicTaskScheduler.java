import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class DynamicJob implements Comparable<DynamicJob> {
    int id;
    int processingTime;
    int arrivalTime;

    public DynamicJob(int id, int processingTime, int arrivalTime) {
        this.id = id;
        this.processingTime = processingTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(DynamicJob other) {
        // Primary sorting by processing time; secondary sorting by arrival time
        if (this.processingTime != other.processingTime) {
            return Integer.compare(this.processingTime, other.processingTime);
        }
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }
}

public class DynamicTaskScheduler {
    public static void main(String[] args) {
        PriorityQueue<DynamicJob> jobQueue = new PriorityQueue<>();
        List<DynamicJob> jobs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("./inputs/task3-input.txt"));
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                int processingTime = scanner.nextInt();
                int arrivalTime = scanner.nextInt();
                jobs.add(new DynamicJob(id, processingTime, arrivalTime));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            return;
        }

        // Sort jobs by arrival time to make processing deterministic
        jobs.sort((a, b) -> Integer.compare(a.arrivalTime, b.arrivalTime));

        int currentTime = 0;
        int totalCompletionTime = 0;
        int index = 0;
        StringBuilder executionOrder = new StringBuilder();

        while (!jobQueue.isEmpty() || index < jobs.size()) {
            // Add all jobs that have arrived by the current time
            while (index < jobs.size() && jobs.get(index).arrivalTime <= currentTime) {
                jobQueue.add(jobs.get(index));
                index++;
            }

            if (!jobQueue.isEmpty()) {
                DynamicJob job = jobQueue.poll();
                currentTime = Math.max(currentTime, job.arrivalTime) + job.processingTime;
                totalCompletionTime += currentTime;
                executionOrder.append(job.id).append(", ");
            } else if (index < jobs.size()) {
                // No job available, jump to the next arrival time
                currentTime = jobs.get(index).arrivalTime;
            }
        }

        double averageCompletionTime = (double) totalCompletionTime / jobs.size();
        System.out.println("Execution order: [" + executionOrder.toString().replaceAll(", $", "") + "]");
        System.out.println("Average completion time: " + averageCompletionTime);
    }
}