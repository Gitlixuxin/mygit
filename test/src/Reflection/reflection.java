package Reflection;
/*
 * 测试代码：部分代码存在重复，是为了练习与熟悉不常用的单词。
 * @author lxx
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflection {

	public static void main(String[] args) {
		//第1种反射方式
		Student stu1=new Student();
		Class stu1Class=stu1.getClass();
		System.out.println(stu1Class.getName());
		//第2种反射方式
		Class stu2Class=Student.class;
		System.out.println(stu1Class==stu2Class);
		//第3种反射方式
		try {
			Class stu3Class=Class.forName("Reflection.Student");
			System.out.println(stu3Class==stu2Class);
			System.out.println("**************所有的公有构造方法*************");
			Constructor[] constructors = stu3Class.getConstructors();
			for(Constructor c: constructors) {
				System.out.println(c);
			}
			System.out.println("**************所有的构造方法*************");
			Constructor[] declaredConstructors = stu3Class.getDeclaredConstructors();
			for(Constructor c: declaredConstructors) {
				System.out.println(c);
			}
			System.out.println("**************公有的无参构造方法*************");
			Constructor constructor = stu3Class.getConstructor(null);
			System.out.println("con=="+constructor);
			System.out.println("**************私有的构造方法*************");
			Constructor constructor2 = stu3Class.getDeclaredConstructor(int.class);
			System.out.println(constructor2);
			constructor2.setAccessible(true);//忽略掉访问修饰符,访问所有；
			constructor2.newInstance(3);
			
			
			//获取字段
			Field[] fields = stu3Class.getFields();
			System.out.println("**************所有公有字段*************");
			for(Field f:fields) {
				System.out.println(f);
			}
			System.out.println("**************所有字段*************");
			Field[] declareFields = stu3Class.getDeclaredFields();
			for(Field f:declareFields) {
				System.out.println(f);
			}
			System.out.println("**************调用公有字段*************");
			Field name = stu3Class.getField("name");
			System.out.println(name);
			Object obj = stu3Class.getConstructor().newInstance();
			name.set(obj, "李虚心");
			Student s=(Student)obj;
			System.out.println(s.name);
			System.out.println("**************调用私有的字段*************");
			Field phoneNum = stu3Class.getDeclaredField("phoneNum");
			System.out.println(phoneNum);
			phoneNum.setAccessible(true);//称之为暴力获取，忽略访问修饰符。
			phoneNum.set(obj, "13636434043");
			String str = s.toString();
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
