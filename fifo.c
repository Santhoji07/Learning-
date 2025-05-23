#include <stdio.h>

int main() {
    int n, f, i, j, pf = 0, victim = 0;
    
    printf("Enter the number of pages: ");
    scanf("%d", &n);
    
    int ref[n];
    printf("Enter the reference string: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &ref[i]);
    }
    
    printf("Enter number of frames: ");
    scanf("%d", &f);
    
    int frame[f];
    for (j = 0; j < f; j++) {
        frame[j] = -1; // Initialize frames to empty
    }

    printf("\nFIFO Page Replacement\nReference String:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", ref[i]);
    }
    printf("\n\n");

    for (i = 0; i < n; i++) {
        int found = 0; // Check if the page is already in frame

        for (j = 0; j < f; j++) {
            if (frame[j] == ref[i]) {
                found = 1; // Page hit
                break;
            }
        }

        if (!found) { // Page miss
            pf++; // Increment page faults
            frame[victim] = ref[i]; // Replace victim frame
            victim = (victim + 1) % f; // FIFO replacement
        }

        printf("%d -> ", ref[i]);
        for (j = 0; j < f; j++) {
            if (frame[j] == -1)
                printf(" - "); // Empty frame
            else
                printf(" %d ", frame[j]);
        }

        printf(found ? "\tPage hit\n" : "\tPage miss\n");
    }

    printf("\nTotal number of page faults: %d\n", pf);
    return 0;
}
