#include <stdio.h>
struct Process
{
    int burst_time;
    int wait_time;
    int turn_time;
    int remaining_time;
} p[10];
int main()
{
    int n, time_quantum, completed = 0, current_time = 0;
    float total_wait = 0, total_turn = 0, avg_wait, avg_turn;
    printf("Enter the number of Processes: ");
    scanf("%d", &n);
    printf("Enter the Time Quantum: ");
    scanf("%d", &time_quantum);
    for (int i = 0; i < n; i++)
    {
        printf("Enter the Burst Time for Process %d: ", i + 1);
        scanf("%d", &p[i].burst_time);
        p[i].remaining_time = p[i].burst_time;
        p[i].wait_time = 0; // Initialize wait time
        p[i].turn_time = 0; // Initialize turnaround time
    }
    int queue[n], front = 0, rear = 0;
    // Enqueue all processes initially
    for (int i = 0; i < n; i++)
    {
        queue[rear++] = i;
    }
    while (completed < n)
    {
        int i = queue[front]; // Process from front of the queue
        front++;
        if (p[i].remaining_time > 0)
        {
            if (p[i].remaining_time > time_quantum)
            {
                current_time += time_quantum;
                p[i].remaining_time -= time_quantum;
                queue[rear++] = i; // Re-enqueue the process
            }
            else
            {
                current_time += p[i].remaining_time;
                p[i].remaining_time = 0;
                p[i].turn_time = current_time;
                p[i].wait_time = p[i].turn_time - p[i].burst_time;
                completed++;
            }
        }
    }
    // Calculate total wait time and turnaround time
    for (int i = 0; i < n; i++)
    {
        total_wait += p[i].wait_time;
        total_turn += p[i].turn_time;
    }
    avg_wait = total_wait / n;
    avg_turn = total_turn / n;
    printf("\nProcess\tWaiting Time\tTurnaround Time\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d\t%d\t\t%d\n", i + 1, p[i].wait_time, p[i].turn_time);
    }
    printf("\nAverage Waiting Time: %.2f\n", avg_wait);
    printf("Average Turnaround Time: %.2f\n", avg_turn);
    return 0;
}
