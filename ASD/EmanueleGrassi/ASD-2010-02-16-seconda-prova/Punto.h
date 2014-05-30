#ifndef PUNTO_H_INCLUDED
#define PUNTO_H_INCLUDED

typedef struct {
    int x;
    int y;
} punto;

punto minore(punto, punto);
double distanza(punto, punto);

#endif // PUNTO_H_INCLUDED
