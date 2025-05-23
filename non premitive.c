C Program for Non-Preemptive Priority Scheduling
#include <stdio.h>
struct Process
{
    int id, arrival_time, burst_time, priority, completion_time, waiting_time, turnaround_time;
};
void findPriorityScheduling(struct Process p[], int n)
{
    // Sort processes by priority
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (p[i].priority > p[j].priority)
            {
                struct Process temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
    }
    int current_time = 0;
    float total_wt = 0, total_tat = 0;
    printf("\nProcess\tAT\tBT\tPriority\tCT\tTAT\tWT\n");
    for (int i = 0; i < n; i++)
    {
        current_time = (current_time < p[i].arrival_time) ? p[i].arrival_time : current_time;
        p[i].completion_time = current_time + p[i].burst_time;
        p[i].turnaround_time = p[i].completion_time - p[i].arrival_time;
        p[i].waiting_time = p[i].turnaround_time - p[i].burst_time;
        total_wt += p[i].waiting_time;
        total_tat += p[i].turnaround_time;
        current_time = p[i].completion_time;
        printf("P%d\t%d\t%d\t%d\t\t%d\t%d\t%d\n", p[i].id, p[i].arrival_time, p[i].burst_time,
               p[i].priority, p[i].completion_time, p[i].turnaround_time, p[i].waiting_time);
    }
    printf("\nAverage Waiting Time: %.2f", total_wt / n);
    printf("\nAverage Turnaround Time: %.2f\n", total_tat / n);
}
int main()
{
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);
    struct Process p[n];
    for (int i = 0; i < n; i++)
    {
        p[i].id = i + 1;
        printf("Enter Arrival Time, Burst Time, and Priority for Process P%d: ", p[i].id);
        scanf("%d %d %d", &p[i].arrival_time, &p[i].burst_time, &p[i].priority);
    }
    findPriorityScheduling(p, n);
    return 0;
}
