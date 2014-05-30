#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

#include "numTree.h"

typedef struct elem2{
    int info;
    struct elem2 *next;
} lista;

int contaDiagonale(tree*, lista*);

#endif // LISTA_H_INCLUDED
