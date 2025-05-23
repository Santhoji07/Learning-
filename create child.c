#include<stdio.h>
#include<unistd.h>

int main(){
    pid_t pid;
    pid=fork();

    if(pid==-1){
        printf("fork failed");
    }
    else if(pid==0){
        printf("Child process");
    }
    else{
        printf("Parent process");
    }
    return 0;
}