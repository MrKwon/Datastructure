#include <iostream>
#include "Currency.h"

// cur07을 없앨 수 있는 방법을 찾아라 !

using namespace std;

int main(void) {
    Currency cur01(10, 275);
    Currency cur02(7, 10);
    Currency cur03(0, 0);
    Currency *cur04 = new Currency(0, 508);
    Currency *cur05 = new Currency(20);
    Currency *cur06 = new Currency(0, 99);
    
    printf("Input your pocket's money\n");
    cin >> cur03;
    
    printf("your Money :\n");
    cout << cur03 << endl;
    
    printf("others\n");
    cout << cur01 << endl;
	cout << cur02 << endl;
	cout << cur03 << endl;
	cout << *cur04 << endl;
	cout << *cur05 << endl;
	cout << *cur06 << endl;
	
	Currency cur07 = cur01.Add(cur02);
	cout << cur07 << endl;
	
	cur07 = cur04->Subtract(cur01);
	cout << cur07 << endl;

    cur07 = cur03.Subtract(*cur05);
    cout << cur07 << endl;

    cur07 = cur06->MultInt(9);
    cout << cur07 << endl;
}


