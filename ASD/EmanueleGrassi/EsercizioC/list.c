#include "list.h"
#include <stdio.h>

void eliminaParole(tree* t, lista** l)
{
    lista *temp = *l;
    while (temp != NULL)
    {
        if (cercaParola(t,temp->info) == 0){
            if (temp->prev == NULL)
                *l = temp->next;
            else
            {
                temp->prev->next = temp->next;
                if (temp->next != NULL)
                    temp->next->prev = temp->prev;
                lista *f = temp;
                free(f);
            }
        }
        temp = temp->next;
    }
}

void createBinFile(tree* t, lista* l)
{
    eliminaParole(t,&l);
    FILE *pf;
    char str[15];
    pf = fopen("parolePari.dat", "bw");
    if (pf == NULL)
    {
        printf("errore di i/O");
        return;
    }
    while (l!= NULL)
    {
        if (ePari(l->info) == 1)
        {
            fwrite(str, sizeof(str), 1, pf);
        }
        l = l->next;
    }
}

int ePari(char* s)
{
    return lung(s)%2 == 0;
}

int lung(char* s)
{
    int l = 0;
    while (s[l] != '\0')
    {
        l++;
    }
    return l;
}
