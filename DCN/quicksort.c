#include <stdio.h>
#include <stdlib.h>

struct packet{
    int id;
    char msg[100];
    float time;
}p[100], temp;

void quicksort(int left, int right){
    int i, j, pivot;
    if(left<right){
        i= left;
        j= right;
        pivot=p[left].id;
        do{
            do{
                i++;
            }
            while(p[i].id<pivot && i<=right);
            do{
                j--;
            }
            while(p[j].id>pivot&& j>=left);
            if(i<j){
                temp=p[i];
                p[i]=p[j];
                p[j]=temp;
            }
        }
        while(i<=j);
        temp=p[left];
        p[left]=p[j];
        p[j]=temp;

        quicksort(left,j-1);
        quicksort(j+1,right);
    }
}
void main(){
    int i, j, n, m;
    printf("Enter the number of packets: ");
    scanf("%d", &n);
    for(i=0;i<n;i++){
        slabel:
        m=rand()%10000;
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
    quicksort(0,n-1);
    printf("After sorting:\n");
    for(i=0;i<n;i++){
        printf("ID: %d, Message: %s, Time: %.2f\n", p[i].id, p[i].msg, p[i].time);
    }
}
