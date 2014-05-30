#include <stdio.h>
#include <string.h>
#include "tree.h"

int cercaParola(tree* t, char* str)
{
    if (t == NULL) return 0;
    if (str[0] == '\0') return 1;
    else
    {
        if (t->info == str[0])
            return checkParola(t->left, str+1) || checkParola(t->right, str+1);
        else
            return (cercaParola(t->left, str) || cercaParola(t->right, str));
    }
}

int checkParola(tree* t, char* str)
{
    if (str[0] == '\0') return 1;
    if (t == NULL) return 0;
    else
    {
        if (t->info == str[0])
            return checkParola(t->left, str+1) || checkParola(t->right, str+1);
        else
            return 0;
    }
}
