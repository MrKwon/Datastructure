#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

#include <iostream>

using namespace std;

class Polynomial;

class Term{
friend class Polynomial;

private:
    float coef; // 계수
    int exp; // 지수
};

class Polynomial {
private:
    Term *termArray; // 0이 아닌 항의 배열
    int capacity; // termArray의 크기
    int terms; // 0이 아닌 항의 수

public:
    Polynomial();
    Polynomial Add(Polynomial);
    Polynomial Mult(Polynomial);
    void NewTerm(const float, const int);
    float Eval(float);

    friend ostream& operator<<(ostream&, Polynomial&);
    friend istream& operator>>(istream&, Polynomial&);
};

#endif