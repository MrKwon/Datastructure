#include <iostream>
#include "Polynomial.h"
#include <math.h>
#define ABS(a) ((a)<0 ? -(a):(a))

using namespace std;

// Term *termArray; // 0이 아닌 항의 배열
// int capacity; // termArray의 크기
// int terms; // 0이 아닌 항의 수

Polynomial::Polynomial() : capacity(4), terms(0)
{
    termArray = new Term[capacity];
}

Polynomial Polynomial::Add(Polynomial b) {
// *this 와 b를 더한 결과를 반환
    Polynomial c;
    int aPos = 0, bPos = 0;
    while ((aPos < terms) && (bPos < b.terms)) {
        if (termArray[aPos].exp == b.termArray[bPos].exp) {
            float tmpCoef = termArray[aPos].coef + termArray[bPos].coef;
            if (tmpCoef) {
                c.NewTerm(tmpCoef, termArray[aPos].exp);
            }
            aPos++;
            bPos++;
        }
        else if(termArray[aPos].exp > b.termArray[bPos].exp) {
            c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
            aPos++;
        }
        else {
            c.NewTerm(termArray[bPos].coef, termArray[bPos].exp);
            bPos++;
        }
    }

    for( ; aPos < terms; aPos++ ) {
        c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
    }

    for( ; bPos < b.terms; bPos++ ) {
        c.NewTerm(termArray[bPos].coef, termArray[bPos].exp);
    }

    return c;
}

Polynomial Polynomial::Mult(Polynomial b) {
// *this 와 b를 곱한 결과를 반환
    Polynomial c;
    int aPos = 0, bPos = 0;
    
    while (bPos < b.terms) {
        while (aPos < terms) {
            Polynomial tmp;
            float tmpCoef = termArray[aPos].coef * b.termArray[bPos].coef;
            int tepExp = termArray[aPos].exp + b.termArray[bPos].exp;
            tmp.NewTerm(tmpCoef, tmpExp);
            c.Add(tmp);
            aPos++;
        }
        bPos++;
    }

    return c;
}

void Polynomial::NewTerm(const float addCoef, const int addExp) {
// 새로운 항을 termArray 끝에 첨가
    if (terms == capacity) {
        capacity *= 2;
        Term *temp = new Term[capacity];
        copy(termArray, termArray + terms, temp);
        delete [] termArray;
        termArray = temp;
    }

    termArray[terms].coef = addCoef;
    termArray[terms].exp = addExp;
}

float Polynomial::Eval(float x){
    float result;

    for(int pos = 0; pos < terms; pos++) {
        float tmp = termArray[pos].coef * pow(x, termArray[pos].exp);
        result += tmp;
    }

    return result;
}

ostream& operator<<(ostream& os, Polynomial& p) {
    for (int i = 0; i < p.terms; i++)
	{
		if ((i != 0) && (p.termArray[i].coef > 0))
			os << "+";
		else if ((i != 0)&&(p.termArray[i].coef < 0))
			os << "-";
		else
			os;
		
		if ((p.termArray[i].coef == 1) || (p.termArray[i].coef == -1))
			os << "x^" << p.termArray[i].exp << ' ';
		else if (p.termArray[i].exp == 0)
			os << ABS(p.termArray[i].coef);
		else
			os << ABS(p.termArray[i].coef) << "x^" << p.termArray[i].exp << ' ';
	}
	return os;
}

istream& operator>>(istream& is, Polynomial& p) {
    int noofterms; float coef; int exp;
	is >> noofterms;
	for (int i = 0; i < noofterms; i++) {
		is >> coef >> exp;
		p.NewTerm(coef, exp);
	}
	return is;
}

using namespace std;

int main(void) {
    Polynomial p1, p2, p3;

	printf("p1 입력 : "); 
	cin >> p1;
	cout << endl;
	
	printf("p2 입력 : "); 
	cin >> p2;
	cout << endl;
	
	p3 = p1.Add(p2);
	cout << p1 << p2 << p3;
	
	return 0;
}
