#ifndef NUMTREE_H_INCLUDED
#define NUMTREE_H_INCLUDED

typedef struct elem{
    int info;
    struct elem *left, *right;
} tree;

int** creaMatrice(tree*);
int altezza(tree*);
int foglie(tree*);
void createTextFile(tree*);




#endif // NUMTREE_H_INCLUDED
