#include <iostream>

using namespace std;

class Rectangle {
public:
    Rectangle();
    Rectangle(int, int, int, int);
//    ~Rectangle();
    int GetHeight();
    int GetWidth();
    int GetxLow();
    int GetyLow();

    // void SetHeight(int);
    // void SetWidth(int);
    // void SetxLow(int);
    // void SetyLow(int);

    bool operator==(const Rectangle &);
    bool operator<(const Rectangle &);

private:
    int xLow, yLow, height, width;

friend ostream& operator<<(ostream &, Rectangle &);
friend istream& operator>>(istream &, Rectangle &);
};

//Rectangle::Rectangle(int x, int y, int h, int w)
//{    xLow = x; yLow = y; height = h; width = w;    }

Rectangle::Rectangle(int x = 0, int y = 0, int h = 0, int w = 0) // 기정 생성자 정의
: xLow(x), yLow(y), height(h), width(w)
{}

// 파괴자 ~Rectangle 은 자동으로 실행됨
// new 키워드를 이용해 생성한 인스턴스가 가리키는 객체는 파괴자를 정의하지 않으면 소멸되지 않는다.

int Rectangle::GetHeight() { return height; }
int Rectangle::GetWidth() { return width; }
int Rectangle::GetxLow() { return xLow; }
int Rectangle::GetyLow() { return yLow; }

// void Rectangle::SetHeight(int height) { this.height = height; }
// void Rectangle::SetWidth(int width) { this.width = width; }
// void Rectangle::SetxLow(int xLow) { this.xLow = xLow; }
// void Rectangle::SetyLow(int yLow) { this.yLow = yLow; }

bool Rectangle::operator==(const Rectangle & s) {
    if (this == &s) return true;
    if ((xLow == s.xLow) && (yLow == s.yLow)
        && (height == s.height) && (width == s.width)) return true;
    else return false;
}

bool Rectangle::operator<(const Rectangle & s) {
    if (this == &s) return false;
    if ( height * width > s.height * s.width ) return false;
    else return true;
}

ostream& operator << (ostream & os, Rectangle & r) {
    os << "Position is : " << "(" << r.GetxLow() << ", " << r.GetyLow() << ")" << endl;
    os << "Height is : " << r.GetHeight() << endl;
    os << "Width is : " << r.GetWidth() << endl;
}

// istream& operator >> (istream & is, Rectangle & r) {
//     int x, y, h, w;
//     cout << "xLow : ";
//     is >> x;
//     cout << "yLow : ";
//     is >> y;
//     cout << "height : ";
//     is >> h;
//     cout << "width : ";
//     is >> w;
// }

int main(void) {
    Rectangle r(1, 3, 6, 6);
    Rectangle *s = new Rectangle(0, 0, 3, 4);
    
    cout << "[[output mode test]]" << endl;

    if(r.GetHeight() * r.GetWidth() > s -> GetHeight() * s -> GetWidth())
        cout << "r";
    else
        cout << "s";

    cout << " has the greater area" << endl;

	cout << r << endl;
	cout << *s << endl;
    // cout << "[[input mode test]]" << endl;
    // Rectangle inRec(0, 0, 0, 0);
    // cin >> inRec;
    // cout << inRec << endl;

    return 0;
}
