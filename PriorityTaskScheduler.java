public class PriorityTaskScheduler {
    
    class JobWithPriority implements Comparable<JobWithPriority> {
        int id;
        int processingTime;
        int priority;

        public JobWithPriority(int id, int processingTime, int priority) {
            this.id = id;
            this.processingTime = processingTime;
            this.priority = priority;
        }

        @Override
        public int compareTo(JobWithPriority other) {
            if (this.priority != other.priority) {
                return Integer.compare(this.priority, other.priority);
            }
            return Integer.compare(this.processingTime, other.processingTime);
        }
    }
}
