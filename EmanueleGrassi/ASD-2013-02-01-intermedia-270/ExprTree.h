#ifndef EXPRTREE_H_INCLUDED
#define EXPRTREE_H_INCLUDED

#include "Espressione.h"

typedef struct elem3{
    tree info;
    struct elem3 *left, *right;
} exprTree;

exprTree* createABR(lista*);

#endif // EXPRTREE_H_INCLUDED
