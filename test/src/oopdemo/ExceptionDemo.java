package oopdemo;

public class ExceptionDemo{
	
	
	public void chu() throws MyException{
		int b=0;
		int a=0;
		if(b==0) {
			throw new MyException();
		}
			a=4/b;
			System.out.println("a="+a);
			System.out.println("����������ǽ����"+a);
	}

	public static void main(String[] args){
		ExceptionDemo en=new ExceptionDemo();
		try {
			en.chu();
		} catch (MyException e) {
			System.out.println(e.execpMessage());
		}finally {
		long vmFree = 0;
		long vmUse = 0;
		long vmTotal = 0;
		long vmMax = 0;
		int byteToMb = 1024 * 1024;
		Runtime rt = Runtime.getRuntime();
		vmTotal = rt.totalMemory() / byteToMb;
		vmFree = rt.freeMemory() / byteToMb;
		vmMax = rt.maxMemory() / byteToMb;
		vmUse = vmTotal - vmFree;
		System.out.println("JVM�ڴ����õĿռ�Ϊ��" + vmUse + " MB");
		System.out.println("JVM�ڴ�Ŀ��пռ�Ϊ��" + vmFree + " MB");
		System.out.println("JVM���ڴ�ռ�Ϊ��" + vmTotal + " MB");
		System.out.println("JVM���ڴ�ռ�Ϊ��" + vmMax + " MB");

		

}}}
