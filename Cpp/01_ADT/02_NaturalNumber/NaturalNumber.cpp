#include <iostream>
#include "NaturalNumber.h"

using namespace std;

int main(void) {
    NaturalNumber num0(1);
    NaturalNumber num1(5);
    
    NaturalNumber *num2 = new NaturalNumber(1000);
    NaturalNumber *num3 = new NaturalNumber(10);
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;
    
    cout << "Member Function : Zero" << endl;
    num0.Zero();
    cout << "num0.Zero() : " << num0 << endl;
    cout << endl;
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;

    cout << "Member Function : IsZero" << endl;
    cout << "num0 : " << num0.IsZero() << endl;
    cout << "num1 : " << num1.IsZero() << endl;
    cout << "*num2 : " << num2 -> IsZero() << endl;
    cout << "*num3 : " << num3 -> IsZero() << endl;
    cout << endl;
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;

    cout << "Member Function : Add"<< endl;
    num0 = num0.Add(num1);
    num1 = num1.Add(*num2);
    *num3 = num3 -> Add(num0);
    cout << "result under MAXINT : " << num0 << endl;
    cout << "result over MAXINT : " << num1 << endl;
    cout << "*num3 : " << *num3 << endl;
    cout << endl;
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;

    cout << "Member Function : Equal" << endl;
    cout << "result : " << num1.Equal(*num2) << endl;
    cout << "result : " << num2 -> Equal(num1) << endl;
    cout << "result : " << num0.Equal(num1) << endl; 
    cout << "result : " << num2 -> Equal(*num3) << endl;
    cout << endl;
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;

    cout << "Member Function : Successor" << endl;
    *num2 = num2 -> Successor();
    num1 = num1.Successor();    
    cout << "result of Successor(1000) : " << *num2 << endl;
    cout << "result of Successor(5) : " << num1 << endl;
    cout << endl;
    
    cout << "[[[NaturalNumbers]]]" << endl;
    cout << "num0 " << num0 << endl;
    cout << "num1 " << num1 << endl;
    cout << "*num2 " << *num2 << endl;
    cout << "*num3 " << *num3 << endl;
    cout << endl;

    cout << "Member Function : Subtract" << endl;
    *num2 = num2 -> Subtract(*num3);
    num0 = num0.Subtract(num1);
    cout << "result of Subtract over 0 : " << *num2 << endl;
    cout << "result of Subtract under 0 : " << num0 << endl;

    return 0;
}
