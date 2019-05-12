package test;

import java.util.regex.Pattern;

/*
 * 小例子
 * java正则表达式； pattern 美[ˈpætərn];
*/
public class patternTest {

	public static void main(String[] args) {
		String content="111111";
		String pattern ="^[1-9]\\d{5}$";//邮编
		boolean isMatch=Pattern.matches(pattern, content);
		System.out.println("是中文字符吗："+isMatch);
	}

}
