#include <stdio.h>
#include <math.h>
#include "numTree.h"

int** creaMatrice(tree* t)
{
    int f = foglie(t);
    int h = altezza(t);
    int** M = calloc(h+1, sizeof(int*));
    int i,j;
    i = j = 0;
    for (i=0; i<f;i++)
        M[i] = calloc(f,sizeof(int));

    for (i=0; i<h;i++)
        for(j = 0; j<f; j++)
            M[i][j] = 0;
    riempiMatrice(M, t,0,0);
    return M;
}

void riempiMatrice(int **M, tree *t, int riga, int colonna)
{
    if (t == NULL) return;
    else M[riga][colonna] = t->info;
    riempiMatrice(M, t->left, riga+1, colonna);
    riempiMatrice(M, t->right, riga+1, colonna+1);
}

int altezza(tree* t)
{
    if (t == NULL)
        return -1;
    else
    {
        int l = altezza(t->left);
        int r = altezza(t->right);
        if (l>r)
            return l+1;
        else
            return r+1;
    }
}

int foglie(tree* t)
{
    return pow(2,altezza(t));
}

void createTextFile(tree* t)
{
    FILE *pf;
    fopen("colonne.txt", "w");
    int ** M = creaMatrice(t);
    int h = altezza(t);
    int f = foglie(t);
    int i,j;
    i = j = 0;
    for (i = 0; i<f; i++){
        for (j = 0; j<h; j++)
            fprintf(pf,"%d ", M[j][i]);
        fprintf(pf, "\n");
    }
    fclose(pf);
}
