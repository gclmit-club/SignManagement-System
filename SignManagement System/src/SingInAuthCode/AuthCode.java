package SingInAuthCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AuthCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 创建一个集合，录入1至9这十个数字
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		// 将集合内数字顺序打乱
		Collections.shuffle(list);
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int a = 0; a < 6; a++) {
			System.out.print(list.get(a));
			num.add(list.get(a));
		}
		System.out.println();
		// 将验证码转换成字符串类型
		String convert = "";
		for (int b : num) {
			convert += b;
		}
		// 键盘输入验证码并对比验证码是否正确，正确进入管理页面，有误则重新输入。
		System.out.print("输入验证码");
		String number = sc.next();
		while ((number.equals(convert)) != true) {
			System.out.print("验证码错误，重新输入");
			number = sc.next();
		}
	}
}
