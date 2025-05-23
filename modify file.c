#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>
#include<fcntl.h>

int main(){
    pid_t=pid;
    pid=fork()
    if(pid==0){
        int fd=open("test.txt", O_WRONLY | O_CREAT, 0644);
        write(fd, "Child process",14);
        close(fd);
    }
    else{
        wait(NULL);
        int fd=open("test.txt",O_WRONLY | O_APPEND, 0644)
        write(fd,"Parent Process", 14);
        close(fd);
    }
    return 0;
}