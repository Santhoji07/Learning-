#include <stdio.h>
#include <string.h>

// Perform Mod-2 division
void xorOperation(char *dividend, char *divisor, int pos) {
    for (int i = 0; divisor[i] != '\0'; i++) {
        dividend[pos + i] = (dividend[pos + i] == divisor[i]) ? '0' : '1';
    }
}

// Function to perform CRC at sender and simulate receiver
void crc(char original[], char pattern[]) {
    int msg_len = strlen(original);
    int pat_len = strlen(pattern);
    int fcs_len = pat_len - 1;

    // Append (n-1) zeros to original message
    char appended[200], transmitted[200];
    strcpy(appended, original);
    for (int i = 0; i < fcs_len; i++)
        strcat(appended, "0");

    printf("After Appending Q is : %s\n", appended);

    // Copy to temp for division
    char temp[200];
    strcpy(temp, appended);

    // Perform CRC Division
    for (int i = 0; i <= strlen(original) - 1; i++) {
        if (temp[i] == '1') {
            xorOperation(temp, pattern, i);
        }
    }

    // Get the remainder (last fcs_len bits)
    char remainder[20];
    strncpy(remainder, temp + msg_len, fcs_len);
    remainder[fcs_len] = '\0';

    printf("Remainder R is : %s\n", remainder);

    // Append remainder to original message to form transmitted message
    strcpy(transmitted, original);
    strcat(transmitted, remainder);

    printf("Message to be Transmitted T is : %s\n", transmitted);

    // Option to introduce error
    char ch;
    printf("Do You Want to Introduce error(Y/N) : ");
    scanf(" %c", &ch);

    if (ch == 'Y' || ch == 'y') {
        int pos;
        x:
        printf("Enter the Position (1 to %lu): ", strlen(transmitted));
        scanf("%d", &pos);
        if (pos < 1 || pos > strlen(transmitted)) {
            printf("Invalid Position. Please enter again.\n");
            goto x;
        }

        pos--; // Convert to 0-based index
        transmitted[pos] = (transmitted[pos] == '1') ? '0' : '1';
    }

    // ************ RECEIVER ************
    printf("\n************ RECEIVER ************\n");
    printf("Message received at the Receiver : %s\n", transmitted);

    // Copy transmitted message to temp for receiver CRC check
    strcpy(temp, transmitted);

    for (int i = 0; i <= strlen(transmitted) - pat_len; i++) {
        if (temp[i] == '1') {
            xorOperation(temp, pattern, i);
        }
    }

    // Check if remainder is all 0s
    int error = 0;
    for (int i = strlen(transmitted) - fcs_len; i < strlen(transmitted); i++) {
        if (temp[i] != '0') {
            error = 1;
            break;
        }
    }

    printf("Remainder R is : %s\n", temp + strlen(transmitted) - fcs_len);
    if (error)
        printf("ERROR IN MESSAGE\n");
    else
        printf("MESSAGE WITHOUT ERROR\n");
}

int main() {
    char message[100], pattern[100];

    printf("************ SENDER ************\n");
    printf("Enter Message: ");
    scanf("%s", message);

    printf("Enter Pattern: ");
    scanf("%s", pattern);

    int msg_len = strlen(message);
    int pat_len = strlen(pattern);

    if (pat_len >= msg_len) {
        printf("Pattern size should be less than Message. Please re-enter the Pattern.\n");
        return 0;
    }

    printf("Given Message is : %s\n", message);
    printf("Given Pattern is : %s\n", pattern);
    printf("Message size is : %d\n", msg_len);
    printf("Pattern Size is : %d\n", pat_len);
    printf("FCS : %d bit\n", pat_len - 1);

    crc(message, pattern);

    return 0;
}
