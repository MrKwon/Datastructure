#include <iostream>
#include "CppArray.h"

using namespace std;

CppArray::CppArray(int _size, float _initValue)
{
    arrSize = _size;
    initValue = _initValue;
    arr = new float [arrSize];
    for(int i = 0; i < arrSize; i++) {
        arr[i] = initValue;
        printf("%lf\n", arr[i]);
    }
}

CppArray::~CppArray()
{
    delete [] arr;
}

float & CppArray::operator[] (int index) {
	printf("arrSize : %d, initValue: %f, arr[0]: %f\n", arrSize, initValue, arr[0]);
    if (arrSize < index) { // size - 1 = index
        printf("wow");
        return *(arr + index);
    } else {
        return arr[0];
    }
}

int CppArray::getarrSize() { return arrSize; }
int CppArray::getinitValue() { return initValue; }
float & CppArray::getArr() { return *arr; }

CppArray& CppArray::operator=(const CppArray& cp2) {
    if (arrSize < cp2.arrSize) { // assign 하려는 배열의 크기가 assign 받는 배열의 크기보다 크면
        arrSize = cp2.arrSize;
        delete [] arr;
        arr = new float [cp2.arrSize];
    }

    for(int i = 0; i < arrSize; i++) {
        arr[i] = cp2.arr[i];
        printf("operator = : %d\n", arr[i]);
    }
}

// ostream & operator << (ostream & os, const CppArray & CA) {
//    os << CA.arrSize << end;
//    for(int i = 0; i < CA.getarrSize(); i++) {
//        os << "| " << i << "\t";
//    }
//    os << "|" << endl;

//    for(int i = 0; i < CA.getarrSize(); i++) {
//        os << "| " << CA.arr[i] << "\t";
//    }
//    os << "|" << endl;

//    return os;
// }

// std::ostream & operator << (std::ostream & os, const CppArray *pCA) {
//     os << *pCA << endl;
//     return os;
//}

// istream & operator >> (istream & is, const CppArray & cp){
    
//     return is;
// }

int main(void) {
    CppArray cpp1(2, 2);
    
    CppArray *cpp2;
    cpp2 = new CppArray(3, 1);
    
    CppArray *cpp3 = new CppArray(2,9);
    
    *cpp3 = cpp1;
    
    printf("�̰� �̰��� : %d\n", cpp1[0]);
    printf("�̰� �̰��� : %d\n", &cpp3[0]);

    return 0;
}
