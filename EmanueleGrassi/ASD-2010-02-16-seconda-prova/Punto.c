#include "Punto.h"
#include <math.h>

punto minore(punto a, punto b){
    if (a.x == b.x)
        if (a.y < b.y)
            return a;
        else
            return b;
    if (a.x < b.x)
        return a;
    else
        return b;
}

double distanza(punto a, punto b){
    double x = pow((b.x-a.x),2) - pow((b.y-a.y),2);
    return sqrt(x);
}
