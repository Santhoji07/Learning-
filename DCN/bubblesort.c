#include<stdio.h>
#include<stdlib.h>

struct packet{
    int id;
    char msg[100];
    float time;
}p[100],temp;

void bubbleSort(int n){
    int i,j;
    for(i=0;i<n-i;i++){
        for(j=0;j<n-i-1;j++){
            if(p[j].id>p[j+1].id){
                temp=p[j+1];
                p[j+1]=p[j];
                p[j]=temp;
            }
        }
    } 
}

void main(){
    int i, j, n, m;
    printf("Enter the number of packets: ");
    scanf("%d", &n);
    for(i=0;i<n;i++){
        slabel:
        m=rand()%100;
        for(j=0;j<=i;j++){
            if(p[j].id==m){
                goto slabel;
            }
        }
        p[i].id=m;
        printf("Enter message:");
        scanf("%s", p[i].msg);
        p[i].time=rand();
    }
    printf("Before sorting:\n");
    for(i=0;i<n;i++){
        printf("ID: %d, Message: %s, Time: %.2f\n", p[i].id, p[i].msg, p[i].time);
    }
    bubbleSort(n);
    printf("After sorting:\n");
    for(i=0;i<n;i++){
        printf("ID: %d, Message: %s, Time: %.2f\n", p[i].id, p[i].msg, p[i].time);
    }
}
