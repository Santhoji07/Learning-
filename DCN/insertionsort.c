#include<stdio.h>
#include<stdlib.h>

struct packet{
    int id;
    int pid;
    char msg[100];
    char port[10];
    char src[10];
    char dest[10];
}p[100],temp;

void insertionSort(int n){
    int i, j;
    for(i=1;i<n;i++){
        temp=p[i];
        for(j=i-1;j>=0 && temp.id<p[j].id;j--)
        {
            p[j+1]=p[j];
        }
        p[j+1]=temp;
    }
}

void main(){
    int i, j, n, m;
    printf("Enter the number of packets: ");
    scanf("%d", &n);
    for(i=0;i<n;i++){
        slabel:
        m=rand()%1000;
        for(j=0;j<=i;j++){
            if(p[j].id==m){
                goto slabel;
            }
        }
        p[i].id=m;
        printf("Enter packet ID:");
        scanf("%d", &p[i].pid);
        printf("Enter port:");
        scanf("%s",&p[i].port);
        printf("Enter message:");
        scanf("%s",&p[i].msg);
        printf("Enter source :");
        scanf("%s",&p[i].src);
        printf("Enter destination:");
        scanf("%s",&p[i].dest);
        
    }
    printf("Before sorting:\n");
    for(i=0;i<n;i++){
       printf("PID:%d, Port:%s, SRC:%s, DES:%s, ID:%d, Message:%s\n", 
       p[i].pid, p[i].port, p[i].src, p[i].dest, p[i].id, p[i].msg);

    }
    insertionSort(n);
    printf("After sorting:\n");
    for(i=0;i<n;i++){
        printf("PID:%d, Port:%s, SRC:%s, DES:%s, ID:%d, Message:%s\n", 
       p[i].pid, p[i].port, p[i].src, p[i].dest, p[i].id, p[i].msg);

    }
}
