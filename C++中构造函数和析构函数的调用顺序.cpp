#include<iostream>
using namespace std;
/*
	建立对象的时候： 
	先调用基类的构造函数，然后在调用下一个派生类的构造函数。
	析构对象的时候：
	先调用子类的析构函数，然后在调用父类的析构函数 
*/
class A{
	public:
		A() {
			cout << "A-constucted" << endl;
		}
		~A() {
			cout << "A-deconstructed" << endl;
		}
};

class B:public A {
	public:
	B() {
		cout << "B-constructed" << endl;
	}
	~B() {
		cout << "B-deconstructed" << endl;
	}
};

class C:public B {
	public:
	C() {
		cout << "C-constructed" << endl;
	}
	~C() {
		cout << "C-deconstructed" << endl;
	}
};

int main() {
	C *c=new C();
	delete c;
	return 0;
}


