#include <stdio.h>

typedef int* NEWTYPE;

NEWTYPE ARRAY(int N) {

    if (N % 2 == 0) {
        NEWTYPE array = (int*)malloc(((N*N)/2)*sizeof(int));
        return array;
    }
    else {
        NEWTYPE array = (int*)malloc((((N * N) + 1) / 2) * sizeof(int));
        return array;
    }
}

int STORE(NEWTYPE as, int N, int row, int col, int val) {

    if ((col + row) % 2 == 0 && col < N && row < N) {
        as[FindIndex(N, row, col)] = val;
        return 1;
    }
    else {
        return -1;
    }
}

int FETCH(NEWTYPE as, int N, int row, int col) {

    if ((col + row) % 2 == 0 && col < N && row < N) {
        return as[FindIndex(N, row, col)];
    }
    else {
        return -1;
    }
}

int FindIndex(int N, int row, int col) {

    int index;

    if (N % 2 == 0) {

        index = row * N + col;
        if (row % 2 == 1) {
            index--;
        }
        return index / 2;
    
    }
    else {

        return (row * N + col) / 2;

    }
}


