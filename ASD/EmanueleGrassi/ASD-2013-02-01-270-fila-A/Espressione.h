#ifndef ESPRESSIONE_H_INCLUDED
#define ESPRESSIONE_H_INCLUDED

typedef struct elem{
    int info;
    struct elem *left, *right;
} tree;

typedef struct elem2{
    tree info;
    struct elem2 *next;
} lista;


int solve(tree*);

#endif // ESPRESSIONE_H_INCLUDED
