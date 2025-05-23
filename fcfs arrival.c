#include<stdio.h>

struct Process{
    int pid;
    int bt;
    int wt;
    int tt;
    int at;
    int st;
    int ct;
};

int main(){
    int i,j,n,totwt=0,tottt=0;
    float avgwt,avgtt;

    printf("enter the number of processes:");
    scanf("%d",&n);
    struct Process p[n];

    for(i=0;i<n;i++){
        p[i].pid=i+1;
        printf("Enter the arraival time for process %d:",(i+1));
        scanf("%d",&p[i].at);
        printf("Enter the burst time for process %d:",(i+1));
        scanf("%d",&p[i].bt);
    }
    
    for(i=0;i<n-1;i++){
        for(j=i+1;j<n;j++){
            if(p[i].at>p[j].at){
                struct Process temp=p[i];
                p[i]=p[j];
                p[j]=temp;
            }
        }
    }

    p[0].st=p[0].at;
    p[0].ct=p[0].st+p[0].bt;
    p[0].wt=p[0].st-p[0].at;
    p[0].tt=p[0].ct-p[0].at;
    
    for(i=1; i<n;i++){
        p[i].st=(p[i-1].ct>p[i].at)?p[i-1].ct : p[i].at;
        p[i].ct=p[i].st+p[i].bt;
        p[i].wt=p[i].st-p[i].at;
        p[i].tt=p[i].ct-p[i].at;

    }
    printf("\n FCFS Scheduling with Arrival Time\n");
    printf("\n Procces ID\tAT\tBT\tWT\tTT\n");
    for(i=0;i<n;i++){
        printf("\n %d\t %d\t%d\t%d\t%d",p[i].pid,p[i].at,p[i].bt,p[i].wt,p[i].tt);
        totwt +=p[i].wt;
        tottt +=p[i].tt;
    }
    
    avgwt=(float)totwt/n;
    avgtt=(float)tottt/n;

    printf("\n Total Waiting Time: %dms \n Average Waiting Time: %.2fms",totwt,avgwt);
    printf("\n Total Turnaround Time: %dms \n Average Turnaround Time: %.2fms",tottt,avgtt);
    return 0;;
}
