#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    int a;
    int * p;
    p= malloc(sizeof(int));
    int i=0;
    while(i<5)
    {
        printf("scrivi:\n");
        scanf("%d",p++);
        i++;
    }
    int b=0;
    while(b<5)
    //while(p=!NULL)
    {
     printf("ci sei: %d\n", *(p+b));
     b++;
    }
    return 0;

}
