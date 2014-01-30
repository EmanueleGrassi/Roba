#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#include "tree.h"

typedef struct lista{
    char* info;
    struct lista *next, *prev;
} lista;

void eliminaParole(tree*, lista**);
void createBinFile(tree*, lista*);  //solo lunghezza pari   ParolePari.txt

#endif // LIST_H_INCLUDED
