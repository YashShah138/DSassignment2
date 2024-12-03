# **CS 2341** 
## Assignment 2
* **@author: Yash Shah 49309058**
* **@author: Dani Jerez 49272827**
* **@duedate: October 27, 2024**

### Objective:
The objective of this assignment is to understand and implement priority queues in a real-world scenario where tasks need to be scheduled and processed based on their processing time and priority. You will develop a system to manage and prioritize a large number of tasks efficiently using a priority queue.

### Task 1:
You are given N jobs, where each job j requires tj seconds of processing time. You need to complete all of the jobs but want to maximize customer satisfaction by minimizing the average completion time of the jobs. Completion time of a job is defined as the total time elapsed from the start of the schedule until the job is completed. Using the Shortest Processing Time First (SPT) rule, you need to design a job scheduler that: 
1. Schedules jobs in increasing order of processing time.
2. Outputs the order in which the jobs should be executed.
3. Calculates the average completion time of all jobs.

To solve this problem, you will implement the scheduler using a priority queue (min-heap), where the jobs are prioritized based on their processing times.

**Input:** 
|  Job ID  |  Processing Time  |
|:--------:|:-----------------:|
|     1    |         4         |
|     2    |         2         |
|     3    |         8         |
|     4    |         6         |
|     5    |         1         |

**Output:**
<img width="1440" alt="SC 2024-10-26 at 11 08 44 PM" src="https://github.com/user-attachments/assets/d8f8eb2c-0829-4c6f-b392-ac4c0eb2736e">

 
### Task 2:
Modify the scheduler to handle priority classes, where each job has a priority level and jobs with higher priority (e.g., priority level 1 is higher than priority level 2) should be scheduled before jobs with lower priority. Jobs within the same priority class should still follow the SPT rule.
 
**Input:**
|  Job ID  |  Processing Time  |  Priority Class  |
|:--------:|:-----------------:|:----------------:|
|     1    |         4         |         1        |
|     2    |         2         |         2        |
|     3    |         8         |         2        |
|     4    |         6         |         1        |
|     5    |         1         |         2        |
  
**Output:**
<img width="1440" alt="SC 2024-10-26 at 11 53 10 PM" src="https://github.com/user-attachments/assets/f58233a2-5978-44df-a231-ab720245281d">

 
 
### Task 3:
Simulate an environment where jobs arrive dynamically (i.e., jobs arrive at different times), and you need to handle these dynamically using a priority queue. Use SPT rule for prioritizing jobs.
 
**Input:**
|  Job ID  |  Processing Time  |  Arrival Time  |
|:--------:|:-----------------:|:--------------:|
|     1    |         4         |        0       |
|     2    |         2         |        1       |
|     3    |         8         |        2       |
|     4    |         6         |        3       |
|     5    |         1         |        5       |

- At time 0:
    - Job 1 arrives and is executed first (completion time = 4 seconds).
- At time 1:
    - Job 2 arrives, but Job 1 is still running.
- At time 4:
    - Job 1 finishes, and Job 2 starts (completion time = 6 seconds).
- At time 5:
    - Job 5 arrives while Job 2 is still running.
- At time 6:
    - Job 2 finishes, and Job 5 starts (completion time = 7 seconds).
- At time 7:
    - Job 5 finishes, and Job 4 starts (completion time = 13 seconds).
- At time 13:
    - Job 4 finishes, and Job 3 starts (completion time = 21 seconds).

**Output:**
<img width="1512" alt="Screenshot 2024-12-03 at 10 36 39 AM" src="https://github.com/user-attachments/assets/265a80c5-6b88-4ca6-bbd9-db95f9622425">
Execution order: [60, 23, 12, 38, 31, 8, 91, 81, 52, 24, 18, 73, 48, 36, 41, 3, 56, 92, 35, 40, 47, 7, 59, 49, 19, 37, 14, 16, 1, 10, 55, 45, 80, 26, 72, 5, 76, 39, 54, 22, 51, 63, 88, 29, 34, 2, 30, 93, 17, 15, 89, 83, 74, 97, 20, 65, 13, 33, 95, 69, 57, 62, 99, 28, 79, 50, 21, 98, 9, 71, 67, 84, 11, 70, 6, 78, 77, 25, 96, 4, 46, 53, 68, 64, 87, 42, 82, 90, 94, 86, 32, 85, 27, 43, 44, 66, 100, 61, 75, 58]


Average completion time: 205.05
