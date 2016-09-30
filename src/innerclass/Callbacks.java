package innerclass;

interface Incrementable {
	
	void increment();
}

class Callee1 implements Incrementable {
	private int i = 0;
	public void increment() {
		i++;
		
		System.out.println(i);
	}
}

class MyIncrement {
	void increment() {
		System.out.println("other increment");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}
}

class Callee2 extends MyIncrement {
	private int i = 0;

	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	
	private class Closure implements Incrementable // �ڲ���
	{
		public void increment() {
			Callee2.this.increment();
		}
	}

	Incrementable getCallbackReference() {
		return new Closure(); // �½��ڲ���
	}
}

class Caller {
	private Incrementable callbackRefference;

	Caller(Incrementable cbh) {
		callbackRefference = cbh;
	}

	void go() {
		callbackRefference.increment();// ����increment()����
	}
}

public class Callbacks {
	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());// ���ڲ����е�Closure����Caller
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}