#include<stdio.h>
#include<string.h>

void main(){
    char msg[20];
    char parity[21];
    int count=0;
    int i;
    int option;
    char choice;
    int postion;
    
    printf("***SENDER***\n");
    printf("Enter the message 0's &1's: ");
    scanf("%s", msg);
    for(i=0; msg[i]!='\0';i++){
        if(msg[i]=='1'){
            count++;
        }
    }
    printf("1.ODD Parity(0) 2.EVEN Parity(1)\n Enter the option:");
    scanf("%d", &option);

    int len = strlen(msg);
    strcpy(parity,msg);

    if(option==1){
        if(count%2==0)
            strcat(parity, "0");
            else 
            strcat(parity, "1");
        }else{
            if(count%2==0)
                strcat(parity, "1");
            else
                strcat(parity, "0");
        }

    printf("Message to be Transmitted: %s\n", parity);

    printf("Do yanted to introduce an error? (y/n): ");
    scanf(" %c", &choice);

    if(choice=='y' || choice=='Y'){
        x:
        printf("Enter the position to introduce error (0 to %lu): ", strlen(parity) - 1);
        scanf("%d", &postion);
        if(postion < 0 || postion >= strlen(parity)){
            printf("Invalid position! Please enter a valid position.\n");
            goto x;
        }
        postion-=1;

        parity[postion]= (parity[postion]=='1')? '0' : '1';
    }
    printf("\n ***RECEIVER***\n");
    printf("Received message: %s\n", parity);
    count=0;
    for(i=0;i<strlen(parity)-1;i++){
        if(parity[i]=='1')
            count++;
    }
    char parity_bit=parity[strlen(parity)-1];

    int isEvenParity = (option == 1);
    if(isEvenParity) {
        if((count % 2 == 0 && parity_bit == '0') || (count % 2 == 1 && parity_bit == '1'))
            printf("MESSAGE WITHOUT ERROR\n");
        else
            printf("ERROR IN MESSAGE\n");
    } else {
        if((count % 2 == 0 && parity_bit == '1') || (count % 2 == 1 && parity_bit == '0'))
            printf("MESSAGE WITHOUT ERROR\n");
        else
            printf("ERROR IN MESSAGE\n");

    }
}
