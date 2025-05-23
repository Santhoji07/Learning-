#include<stdio.h>
#include<unistd.h>

int main(){
    fork();
    fork();
    fork();
    printf("Fork Process PID=%d\n", getpid());
    return 0;
}