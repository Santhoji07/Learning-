#include<stdio.h>

struct Process{
    int pid;
    int bt;
    int wt;
    int tt;
};

int main(){
    int i,n,totwt=0,tottt=0;
    float avgwt,avgtt;

    printf("enter the number of processes:");
    scanf("%d",&n);
    struct Process p[n];

    for(i=0;i<n;i++){
        p[i].pid=i+1;
        printf("Enter burst time for process %d:",(i+1));
        scanf("%d",&p[i].bt);
    }
    p[0].wt=0;
    p[0].tt=p[0].bt+p[0].wt;

    for(i=1;i<n;i++){
        p[i].wt=p[i-1].bt+p[i-1].wt;
        p[i].tt=p[i].bt+p[i].wt;
    }
    
    printf("\n FCFS Scheduling\n");
    printf("\n Procces ID\t BT\tWT\tTT\n");
    for(i=0;i<n;i++){
        printf("\n %d\t%d\t%d\t%d",p[i].pid,p[i].bt,p[i].wt,p[i].tt);
        totwt +=p[i].wt;
        tottt +=p[i].tt;
    }
    
    avgwt=(float)totwt/n;
    avgtt=(float)tottt/n;

    printf("\n Total Waiting Time: %dms \n Average Waiting Time: %.2fms",totwt,avgwt);
    printf("\n Total Turnaround Time: %dms \n Average Turnaround Time: %.2fms",tottt,avgtt);
    return 0;;
}
