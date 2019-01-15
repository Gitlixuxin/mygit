package Reflection;
/*
 * ���Դ��룺���ִ�������ظ�����Ϊ����ϰ����Ϥ�����õĵ��ʡ�
 * @author lxx
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflection {

	public static void main(String[] args) {
		//��1�ַ��䷽ʽ
		Student stu1=new Student();
		Class stu1Class=stu1.getClass();
		System.out.println(stu1Class.getName());
		//��2�ַ��䷽ʽ
		Class stu2Class=Student.class;
		System.out.println(stu1Class==stu2Class);
		//��3�ַ��䷽ʽ
		try {
			Class stu3Class=Class.forName("Reflection.Student");
			System.out.println(stu3Class==stu2Class);
			System.out.println("**************���еĹ��й��췽��*************");
			Constructor[] constructors = stu3Class.getConstructors();
			for(Constructor c: constructors) {
				System.out.println(c);
			}
			System.out.println("**************���еĹ��췽��*************");
			Constructor[] declaredConstructors = stu3Class.getDeclaredConstructors();
			for(Constructor c: declaredConstructors) {
				System.out.println(c);
			}
			System.out.println("**************���е��޲ι��췽��*************");
			Constructor constructor = stu3Class.getConstructor(null);
			System.out.println("con=="+constructor);
			System.out.println("**************˽�еĹ��췽��*************");
			Constructor constructor2 = stu3Class.getDeclaredConstructor(int.class);
			System.out.println(constructor2);
			constructor2.setAccessible(true);//���Ե��������η�,�������У�
			constructor2.newInstance(3);
			
			
			//��ȡ�ֶ�
			Field[] fields = stu3Class.getFields();
			System.out.println("**************���й����ֶ�*************");
			for(Field f:fields) {
				System.out.println(f);
			}
			System.out.println("**************�����ֶ�*************");
			Field[] declareFields = stu3Class.getDeclaredFields();
			for(Field f:declareFields) {
				System.out.println(f);
			}
			System.out.println("**************���ù����ֶ�*************");
			Field name = stu3Class.getField("name");
			System.out.println(name);
			Object obj = stu3Class.getConstructor().newInstance();
			name.set(obj, "������");
			Student s=(Student)obj;
			System.out.println(s.name);
			System.out.println("**************����˽�е��ֶ�*************");
			Field phoneNum = stu3Class.getDeclaredField("phoneNum");
			System.out.println(phoneNum);
			phoneNum.setAccessible(true);//��֮Ϊ������ȡ�����Է������η���
			phoneNum.set(obj, "13636434043");
			String str = s.toString();
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
