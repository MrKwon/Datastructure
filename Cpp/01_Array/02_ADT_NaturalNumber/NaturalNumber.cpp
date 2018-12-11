#include <iostream>
#include "NaturalNumber.h"

using namespace std;

//ostream& operator << (ostream& os, NaturalNumber & n);

int main(void) {
    NaturalNumber num0(1);
    NaturalNumber num1(5);
    
    NaturalNumber *num2 = new NaturalNumber(1000);
    NaturalNumber *num3 = new NaturalNumber(5);
    
    cout << "NaturalNumbers" << endl;
    cout << num0 << endl;
    cout << num1 << endl;
    cout << *num2 << endl;
    cout << *num3 << endl;
    cout << endl;
    
    cout << "Member Function : Zero" << endl;
    cout << "num0.Zero() : " << num0.Zero().naturalNumber << endl;
    cout << endl;

    cout << "Member Function : IsZero" << endl;
    cout << "num0 : " << num0.IsZero() << endl;
    cout << "num1 : " << num1.IsZero() << endl;
    cout << "*num2 : " << num2 -> IsZero() << endl;
    cout << "*num3 : " << num3 -> IsZero() << endl;
    cout << endl;

    cout << "Member Function : Add"<< endl;
    cout << "result under MAXINT : " << num0.Add(num1).naturalNumber << endl;
    cout << "result over MAXINT : " << num1.Add(*num2).naturalNumber << endl;
    cout << endl;

    cout << "Member Function : Equal" << endl;
    cout << "result of Equal : " << num1.Equal(*num3) << endl;
    cout << "result of NOT Equal : " << num0.Equal(num1) << endl; 
    cout << "result of NOT Equal : " << num2 -> Equal(*num3) << endl;
    cout << endl;

    cout << "Member Function : Successor" << endl;
    cout << "result of Successor(1000) : " << num2 -> Successor().naturalNumber << endl;
    cout << "result of Successor(5) : " << num1.Successor().naturalNumber << endl;
    cout << endl;

    cout << "Member Function : Subtract" << endl;
    cout << "result of Subtract over 0 : " << num2 -> Subtract(*num3).naturalNumber << endl;
    cout << "result of Subtract under 0 : " << num0.Subtract(num1).naturalNumber << endl;

    return 0;
}

//ostream& operator << (ostream & os, NaturalNumber & n) {
//    os << "Natural Number is : " << n.naturalNumber << endl;
//}
