#include "ExprTree.h"

#include <stdio.h>

exprTree* createABR(lista *a)
{
    exprTree *res;
    if (a != NULL)
    {
        res = malloc(sizeof(tree));
        res->info = a->info;
        res->left = NULL;
        res->right = NULL;
    }
    lista *x = a->next;
    while (x!=NULL)
    {
        inserisci(x->info, &res);
        x = x->next;
    }
    return res;
}

void inserisci(tree *t, exprTree **et)
{
    if ((*et) == NULL)
    {
        exprTree *newtree = malloc(sizeof(exprTree));
        newtree->info = *t;
        newtree->left = NULL;
        newtree->right = NULL;
        *et = newtree;
    }
    if (solve(t) > solve(&((*et)->info)))
        inserisci(t,(&((*et)->right)));
    if (solve(t) < solve(&((*et)->info)))
        inserisci(t,(*et)->left);
}

