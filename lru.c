#include <stdio.h>

int main() {
    int n, f, i, j, pf = 0;

    printf("Enter the number of pages: ");
    scanf("%d", &n);

    int ref[n];
    printf("Enter the reference string: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &ref[i]);
    }

    printf("Enter the number of frames: ");
    scanf("%d", &f);

    int frame[f], lastUsed[f]; // frame[i]: holds page, lastUsed[i]: last used time
    for (j = 0; j < f; j++) {
        frame[j] = -1;      // Empty frame
        lastUsed[j] = 0;    // No time assigned yet
    }

    int time = 0; // To keep track of time for LRU

    printf("\nLRU Page Replacement\nReference String:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", ref[i]);
    }
    printf("\n\n");

    for (i = 0; i < n; i++) {
        int page = ref[i];
        int found = 0;

        // Check if page is already in frame
        for (j = 0; j < f; j++) {
            if (frame[j] == page) {
                found = 1;
                lastUsed[j] = time; // Update last used time
                break;
            }
        }

        // If not found, it's a page fault
        if (!found) {
            pf++;

            // Check for empty frame
            int replaced = 0;
            for (j = 0; j < f; j++) {
                if (frame[j] == -1) {
                    frame[j] = page;
                    lastUsed[j] = time;
                    replaced = 1;
                    break;
                }
            }

            // If no empty frame, replace the least recently used one
            if (!replaced) {
                int minTime = lastUsed[0];
                int victim = 0;
                for (j = 1; j < f; j++) {
                    if (lastUsed[j] < minTime) {
                        minTime = lastUsed[j];
                        victim = j;
                    }
                }
                frame[victim] = page;
                lastUsed[victim] = time;
            }
        }

        time++; // Increase time

        // Print current frame status
        printf("%d -> ", page);
        for (j = 0; j < f; j++) {
            if (frame[j] == -1)
                printf("- ");
            else
                printf("%d ", frame[j]);
        }
        printf(found ? "\tPage hit\n" : "\tPage miss\n");
    }

    printf("\nTotal number of page faults: %d\n", pf);
    return 0;
}
