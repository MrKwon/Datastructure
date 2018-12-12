#ifndef NATURALNUMBER_H
#define NATURALNUMBER_H

#include <ostream>
#include <istream>

unsigned const int MAXINT = 1000;

using namespace std;

class NaturalNumber {
// 컴퓨터에서 0부터 최대 정수(MAXINT : 1000)까지 순서가 있는 정수의 부분 범위
public:

    NaturalNumber(int);
    
    int getNaturalNumber();
    void setNaturalNumber(int);

    NaturalNumber Zero(); // 0을 반환
    bool IsZero(); // *this가 이면 true를 아니면 false 를 반환
    NaturalNumber Add(NaturalNumber y); // *this + y와 MAXINT에서 작은 값을 반환
    bool Equal(NaturalNumber y); // *this == y 이면 true를 아니면 false를 반환
    NaturalNumber Successor(); // *this 가 MAXINT이면 MAXINT를 아니면 *this + 1을 반환
    NaturalNumber Subtract(NaturalNumber y); // *this < y이면 0을 아니면 *this-y를 반환

    
private:
    int naturalNumber;

friend ostream& operator << (ostream &, NaturalNumber &);
// friend istream& operator>>(istream &, NaturalNumber &);
};

NaturalNumber::NaturalNumber(int n = 0)
: naturalNumber(n)
{}

int NaturalNumber::getNaturalNumber() {
    return naturalNumber;
}

void NaturalNumber::setNaturalNumber(int i) {
    naturalNumber = i;
}

NaturalNumber NaturalNumber::Zero() {
    return this -> naturalNumber = 0;
}

bool NaturalNumber::IsZero() {
    if (this -> naturalNumber == 0) { // . 인지 -> 인지 알아보자
        return true; // 1
    } else {
        return false; // 0
    }
}

NaturalNumber NaturalNumber::Add(const NaturalNumber y) {
    NaturalNumber added;
    if ( (this -> naturalNumber + y.naturalNumber) > MAXINT ) {
        added.naturalNumber = this -> naturalNumber = MAXINT;
    } else {
        added.naturalNumber = this -> naturalNumber += y.naturalNumber;
    }

    return added;
}

bool NaturalNumber::Equal(const NaturalNumber y) {
    if (this -> naturalNumber == y.naturalNumber)
        return true;
    else
        return false;
}

NaturalNumber NaturalNumber::Successor() {
    if (this -> naturalNumber == MAXINT)
        return this -> naturalNumber = MAXINT;
    else
        return this -> naturalNumber += 1;
}

NaturalNumber NaturalNumber::Subtract(const NaturalNumber y) {
    if (this -> naturalNumber < y.naturalNumber)
        return this -> naturalNumber = 0;
    else
        return this -> naturalNumber -= y.naturalNumber;
}

 ostream& operator << (ostream & os, NaturalNumber & n) {
     os << "Natural Number is : " << n.naturalNumber;
 }

#endif
