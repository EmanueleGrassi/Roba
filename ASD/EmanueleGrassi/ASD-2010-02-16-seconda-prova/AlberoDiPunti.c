#include "AlberoDiPunti.h"
#include <stdio.h>

void inserisciPunto(tree** t, int x, int y){
    punto p;
    p.x = x;
    p.y = y;
    inserisci(t,p);
}

void inserisci(tree **t, punto p){
    if (*t == NULL)
    {
        tree *x = (tree*)malloc(sizeof(tree));
        x->info = p;
        x->left = NULL;
        x->right = NULL;
    }
    else
    {
        punto b = (*t)->info;
        if (b == minore(b,p))  //cioè se b viene prima di p
            inserisci(&(*t)->left,p);
        else
            inserisci(&(*t)->right, p);
    }
}
