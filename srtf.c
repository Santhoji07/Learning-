#include <stdio.h>
#include <limits.h>
struct Process
{
    int id, arrival_time, burst_time, remaining_time, completion_time, waiting_time,
        turnaround_time;
};
void findSRTF(struct Process p[], int n)
{
    int complete = 0, current_time = 0, min_index = -1;
    int min_remaining = INT_MAX;
    while (complete != n)
    {
        min_index = -1;
        min_remaining = INT_MAX;
        // Find process with shortest remaining time
        for (int i = 0; i < n; i++)
        {
            if (p[i].arrival_time <= current_time && p[i].remaining_time > 0)
            {
                // Choose the process with the shortest remaining time
                if (p[i].remaining_time < min_remaining ||
                    (p[i].remaining_time == min_remaining && p[i].arrival_time < p[min_index].arrival_time))
                {
                    min_remaining = p[i].remaining_time;
                    min_index = i;
                }
            }
        }
        if (min_index == -1)
        {
            // No process is available; jump to the next arriving process
            int next_arrival = INT_MAX;
            for (int i = 0; i < n; i++)
            {
                if (p[i].remaining_time > 0 && p[i].arrival_time > current_time)
                {
                    if (p[i].arrival_time < next_arrival)
                    {
                        next_arrival = p[i].arrival_time;
                    }
                }
            }
            current_time = next_arrival;
            continue;
        }
        // Process executes for 1 unit time
        p[min_index].remaining_time--;
        current_time++;
        // If process completes
        if (p[min_index].remaining_time == 0)
        {
            complete++;
            p[min_index].completion_time = current_time;
            p[min_index].turnaround_time = p[min_index].completion_time - p[min_index].arrival_time;
            p[min_index].waiting_time = p[min_index].turnaround_time - p[min_index].burst_time;
        }
    }
}
void findAverageTime(struct Process p[], int n)
{
    findSRTF(p, n);
    float total_wt = 0, total_tat = 0;
    printf("\nProcess\tAT\tBT\tCT\tTAT\tWT\n");
    for (int i = 0; i < n; i++)
    {
        total_wt += p[i].waiting_time;
        total_tat += p[i].turnaround_time;
        printf("P%d\t%d\t%d\t%d\t%d\t%d\n", p[i].id, p[i].arrival_time, p[i].burst_time,
               p[i].completion_time, p[i].turnaround_time, p[i].waiting_time);
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
        printf("Enter Arrival Time and Burst Time for Process P%d: ", i + 1);
        scanf("%d %d", &p[i].arrival_time, &p[i].burst_time);
        // Validate input
        if (p[i].arrival_time < 0 || p[i].burst_time <= 0)
        {
            printf("Error: Arrival time and burst time must be non-negative.\n");
            return 1;
        }
        p[i].remaining_time = p[i].burst_time;
    }
    findAverageTime(p, n);
    return 0;
}