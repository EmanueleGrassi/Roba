#ifndef TREE_H_INCLUDED
#define TREE_H_INCLUDED

typedef struct tree{
    char info;
    struct tree *left, *right;
} tree;

int cercaParola(tree*, char*);

#endif // TREE_H_INCLUDED
