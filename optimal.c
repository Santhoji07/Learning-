#include <stdio.h>

int n, f;

// Function to find the optimal page to replace
int getOptimalVictim(int ref[], int frame[], int index) {
    int i, j, farthest = index, pos = -1;

    for (i = 0; i < f; i++) {
        int found = 0;
        for (j = index + 1; j < n; j++) {
            if (frame[i] == ref[j]) {
                found = 1;
                if (j > farthest) {
                    farthest = j;
                    pos = i;
                }
                break;
            }
        }
        if (!found) {
            return i; // This page won't be used again
        }
    }

    // If all pages will be used again, replace the farthest one
    return (pos == -1) ? 0 : pos;
}

int main() {
    int i, j, ref[100], frame[100], count = 0, pf = 0, found;

    printf("Enter the number of pages: ");
    scanf("%d", &n);

    printf("Enter the reference string: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &ref[i]);
    }

    printf("Enter the number of frames: ");
    scanf("%d", &f);

    // Initialize frames to -1
    for (i = 0; i < f; i++) {
        frame[i] = -1;
    }

    printf("\nOptimal Page Replacement\n");

    for (i = 0; i < n; i++) {
        found = 0;

        // Check if page is already in a frame
        for (j = 0; j < f; j++) {
            if (frame[j] == ref[i]) {
                found = 1;
                break;
            }
        }

        if (!found) {
            if (count < f) {
                frame[count++] = ref[i]; // Fill empty frame
            } else {
                int victim = getOptimalVictim(ref, frame, i);
                frame[victim] = ref[i]; // Replace optimal victim
            }
            pf++; // Page fault
        }

        // Print current frame state
        printf("%d -> ", ref[i]);
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
