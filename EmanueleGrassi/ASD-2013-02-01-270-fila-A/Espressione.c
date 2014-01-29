#include "Espressione.h"
#include <stdio.h>

tree* createABR(lista);


int solve(tree* t){
    if (t == NULL)
        return 0;
    if (t->left == NULL && t->right == NULL)
        return t->info;
    if (t->left != NULL && t->right != NULL)
    {
        switch (t->info)
        {
            case '+':
                return solve(t->left) + solve(t->right);
                break;
            case '-':
                return solve(t->left) - solve(t->right);
                break;
            case '/':
                return solve(t->left) / solve(t->right);
                break;
            case '*':
                return solve(t->left) * solve(t->right);
                break;
        }
    }
    exit(-1);  //albero malformato
}
