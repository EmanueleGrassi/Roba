#include <stdio.h>
#include "tree.h"

int cercaParola(tree* t, char* str)
{
    if (t == NULL) return 0;
    if (str[0] == '\0') return 1;
    else
    {
        if (t->info == str[0])
            return (cercaParola(t->left, str+1) || cercaParola(t->right, str+1));
        else
            return 0;
    }
}




