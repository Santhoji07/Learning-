#include <stdio.h>

int main() {
    int p, r, i, j, k;

    printf("Enter number of processes: ");
    scanf("%d", &p);

    printf("Enter number of resources: ");
    scanf("%d", &r);

    int alloc[p][r], max[p][r], need[p][r], avail[r];
    int finish[p], safeseq[p];

    // Input Allocation Matrix
    printf("\nEnter the Allocation Matrix:\n");
    for (i = 0; i < p; i++)
        for (j = 0; j < r; j++)
            scanf("%d", &alloc[i][j]);

    // Input Maximum Matrix
    printf("\nEnter the Max Matrix:\n");
    for (i = 0; i < p; i++)
        for (j = 0; j < r; j++)
            scanf("%d", &max[i][j]);

    // Input Available Resources
    printf("\nEnter the Available Resources:\n");
    for (i = 0; i < r; i++)
        scanf("%d", &avail[i]);

    // Calculate Need Matrix = Max - Alloc
    for (i = 0; i < p; i++)
        for (j = 0; j < r; j++)
            need[i][j] = max[i][j] - alloc[i][j];

    // Print Need Matrix
    printf("\nNeed Matrix:\n");
    for (i = 0; i < p; i++) {
        for (j = 0; j < r; j++)
            printf("%d\t", need[i][j]);
        printf("\n");
    }

    // Initialize finish flags to 0
    for (i = 0; i < p; i++)
        finish[i] = 0;

    int count = 0;
    while (count < p) {
        int safe = 0;
        for (i = 0; i < p; i++) {
            if (!finish[i]) {
                int canRun = 1;
                for (j = 0; j < r; j++) {
                    if (need[i][j] > avail[j]) {
                        canRun = 0;
                        break;
                    }
                }

                if (canRun) {
                    for (k = 0; k < r; k++)
                        avail[k] += alloc[i][k];  // Release resources
                    safeseq[count++] = i;
                    finish[i] = 1;
                    safe = 1;
                }
            }
        }

        if (!safe) {
            printf("\nSystem is in **UNSAFE state**. Deadlock may occur.\n");
            return 0;
        }
    }

    // Print Safe Sequence
    printf("\nSystem is in **SAFE state**.\n");
    printf("Safe Sequence: ");
    for (i = 0; i < p; i++)
        printf("P%d ", safeseq[i] + 1);
    printf("\n");

    return 0;
}
