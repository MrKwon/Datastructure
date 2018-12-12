#ifndef CURRENCY_H
#define CURRENCY_H

#include <iostream>

using namespace std;

class Currency {
public:
    Currency();
    Currency(int); // dollar
    Currency(int, int); // dollar + cent

    void SetDollar(int); // setting int dollar(private) mem func
    void SetCents(int); // setting int cents(private) mem func

    int GetDollar(); // return int dollar(private) mem func
    int GetCents(); // return int cents(private) mem func

    Currency Add(Currency); // return Currency *this + param
    Currency Subtract(Currency); // return Currency *this - param
    Currency MultInt(int); // return Currency *this * int
    
private:
    int dollar = 0;
    int cents = 0;
    bool isDollar(int); // return true when cents is over 100
    int centToDollar(int);
    int centToCent(int);

friend ostream& operator << (ostream&, Currency&);
friend istream& operator << (istream&, Currency&);
};

bool Currency::isDollar(int cents) {
    if ((cents / 100) > 1) {
        return true;
    }
    else if ((cents / 100) < 1) {
        return false;
    }
}

int Currency::centToDollar(int cents) {
    if (isDollar(cents)) {
        return cents / 100;
    }
    else if (!isDollar(cents)) {
        return 0;
    }
}

int Currency::centToCent(int cents) {
    if (isDollar(cents)) {
        return cents % 100;
    }
    else if (!isDollar(cents)) {
        return cents;
    }
}

Currency::Currency(int dollar) : dollar(dollar), cents(0) {}

Currency::Currency(int dollar, int cents) {
     if (isDollar(cents)) {
         this->dollar = dollar + centToDollar(cents);
         this->cents = centToCent(cents);
     }
     else {
         this->dollar = dollar;
         this->cents = cents;
     }
 }

void Currency::SetDollar(int dollar) {
    if (dollar < 0) return;

    this->dollar = dollar;
}

void Currency::SetCents(int cents) {
    if (cents < 0) return;

    this->dollar += centToDollar(cents);
    this->cents = centToCent(cents);
}

int Currency::GetDollar() {
    return this->dollar;
}

int Currency::GetCents() {
    return this->cents;
}

Currency Currency::Add(Currency cur) {
    Currency result(0, 0);

    int sumDollar = this->dollar + cur.dollar;
    int sumCent = this->cents + cur.cents;

    sumDollar += centToDollar(sumCent);
    sumCent = centToCent(sumCent);

    result.dollar = sumDollar;
    result.cents = sumCent;

    return result;
}

Currency Currency::Subtract(Currency cur) {
    Currency result(0, 0);

    if (this->dollar - cur.dollar > 0 && this->cents - cur.cents > 0) {
        result.dollar = this->dollar - cur.dollar;
        result.cents = this->cents - cur.cents;
    }
    else if (this->dollar - cur.dollar > 0 && this->cents - cur.cents < 0) {
        result.dollar = this->dollar - cur.dollar - 1;
        result.cents = 1 - (this->cents - cur.cents);
    }
    else if (this->dollar - cur.dollar < 0) {
        result.dollar = 0;
        result.cents = 0;
    }

    return result;
}

Currency Currency::MultInt(int num) {
    Currency result(0, 0);

    int dollarMultNum = this->dollar * num;
    int centMultNum = this->cents * num;

    if (isDollar(centMultNum)) {
        result.dollar = dollarMultNum + centToDollar(centMultNum);
        result.cents = centToCent(centMultNum);
    }
    else {
        result.dollar = dollarMultNum;
        result.cents = centMultNum;
    }

    return result;
}

ostream& operator << (ostream& os, Currency& cur){
    if (cur.dollar <= 0 && cur.cents > 0) {
        os << "\t\t" << cur.cents << " cent(s) ";
    }
    else if(cur.dollar > 0 && cur.cents > 0) {
        os << cur.dollar << " dollar(s) " << "\t" << cur.cents << " cent(s) ";
    }
    else if(cur.dollar > 0 && cur.cents <= 0) {
        os << cur.dollar << " dollar(s) ";
    }
    else {
        os << "No Money To Show !";
    }
    return os;
}

istream& operator >> (istream& is, Currency& cur){
	int dollar = 0;
	int cents = 0;
    cout << "dollar(s) : ";
    is >> dollar;
    cur.SetDollar(dollar);

    cout << "cents(s) : ";
    is >> cents;
    cur.SetCents(cents);

    return is;
}

#endif
