#include "lista.h"
#include <stdio.h>
#include "numTree.h"

int contaDiagonale(tree* t, lista*l)
{
    int cont = 0;
    int **M = creaMatrice(t);
    int h = altezza(t);
    while (l!=NULL){
        if (isPresent(l->info, M, h+1))
            cont++;
    }
    return cont;
}

int isPresent(int l, int** M, int h)
{
    int i;
    for (i = 0; i<h; i++)
        if (M[i][i] == l)
            return 1;
    return 0;
}
