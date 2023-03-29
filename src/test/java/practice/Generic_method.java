package practice;

public class Generic_method {
	public int add(int a,int b) {
		int c=a+b;
		return c;
	}

	public static void main(String[] args) {
		Generic_method p=new Generic_method();
	int sum=p.add(12, 20);
	System.out.println(sum);
	}

}
