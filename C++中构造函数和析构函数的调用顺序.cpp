#include<iostream>
using namespace std;
/*
	���������ʱ�� 
	�ȵ��û���Ĺ��캯����Ȼ���ڵ�����һ��������Ĺ��캯����
	���������ʱ��
	�ȵ������������������Ȼ���ڵ��ø������������ 
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


