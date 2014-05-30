#include <stdio.h>
#include <stdlib.h>
#include "numTree.h"
int main()
{
    printf("Hello world!\n");
    printa();
    return 0;
}
void printa()
{
    int f = 4;
    int h = 7;
    int** M = calloc(h, sizeof(int*));
    int i,j;
    i = j = 0;
    for (i=0; i<h;i++)
        M[i] = calloc(f,sizeof(int));

    for (i=0; i<h;i++)
        for(j = 0; j<f; j++)
            M[i][j] = 0;
    for (i=0; i<h;i++){
        for(j = 0; j<f; j++)
            printf("%d ", M[i][j]);
        printf("\n");
    }
}
