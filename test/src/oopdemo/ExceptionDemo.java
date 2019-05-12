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
			System.out.println("上面输出的是结果！"+a);
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
		System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
		System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
		System.out.println("JVM总内存空间为：" + vmTotal + " MB");
		System.out.println("JVM总内存空间为：" + vmMax + " MB");

		

}}}
