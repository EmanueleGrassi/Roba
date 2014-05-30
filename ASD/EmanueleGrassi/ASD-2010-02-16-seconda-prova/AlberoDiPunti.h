#ifndef ALBERODIPUNTI_H_INCLUDED
#define ALBERODIPUNTI_H_INCLUDED

#include "punto.h"

typedef struct elem{
    punto info;
    struct elem *left;
    struct elem *right;
} tree;

void inserisciPunto(tree**, int, int);
void elimina(tree**, int, int, int); //x,y,distanza

#endif // ALBERODIPUNTI_H_INCLUDED
