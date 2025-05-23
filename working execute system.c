#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main(){
    pid_t=pid;
    pid=fork();

    if(pid=0){
        execlp("bin/ls","ls",NULL);
        perror("Exclp failed");
    }else if(pid>0){
        wait(NULL);
        printf("Parent Process: Child process executed\n");
    }else{
        perror("Fork failed");
    }
    retuen 0;
}