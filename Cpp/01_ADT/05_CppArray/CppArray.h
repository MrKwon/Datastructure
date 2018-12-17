#ifndef CPPARRAY_H
#define CPPARRAY_H

#include <iostream>

using namespace std;

class CppArray {

    //friend ostream & operator << (ostream &, const CppArray &); // cout 배열 출력
    friend ostream & operator << (ostream &, const CppArray *);
    friend istream & operator >> (istream &, const CppArray &); // cin 배열 입력

private:
    float * arr;
    int arrSize;
    float initValue;

public:
    CppArray() {}
    CppArray(int, float);  // constructor
    ~CppArray();    // destructor

    float & operator[] (int); // 영역검사
    int getarrSize(); // 배열의 크기를 반환하는 함수 제공
    int getinitValue();
    float & getArr();

    void setSize();
    void setInitValue();

    CppArray & operator=(const CppArray&); // 한 배열을 다른 배열에 치환하는 것이 가능
};

#endif
