package SignInChangePassWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SignInStaff.Staff;

public class ChangePassWord {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入姓名：");
		String name = sc.next();
		System.out.print("请输入学习方向：");
		String direction = sc.next();
		System.out.print("请输入性别：");
		char sex = sc.next().charAt(0);
		System.out.print("输入ID：");
		int id = sc.nextInt();
		// 创建Staff类，并调用它的String1方法
		Staff staffTwo = new Staff(name, id, direction, sex);
		String staffTwoString1 = staffTwo.toString1();
		// 创建BufferedReader读取"data.txt"中的信息
		BufferedReader bf = new BufferedReader(new FileReader("data.txt"));
		int bfReadCodingDate = 0;
		String bfReadDate = "";
		List<String> listNewDate = new ArrayList();
		while ((bfReadCodingDate = bf.read()) != -1) {
			Character ch = (char) bfReadCodingDate;
			bfReadDate += ch.toString();
		}
		// 关闭流
		bf.close();
		// 以“。”为界，分割字符串str1，存储进数组中
		String[] stringBfrOneArray = bfReadDate.split("。");
		int signCound = 0;
		int h = 0;
		for (int i = 0; i < stringBfrOneArray.length; i++) {
			// 当输入的信息与"data.txt"一致时，记住这是第几个，然后可以直接修改密码
			if (staffTwoString1.equals(stringBfrOneArray[i])) {
				signCound = i;
				h = 1;
			}
		}
		// 当信息输入正确时，开始密码的改写
		if (h == 1) {
			BufferedReader br1 = new BufferedReader(new FileReader("user.txt"));
			int bfReadCodingUser;
			String bfReadUser = "";
			List list2 = new ArrayList();
			while ((bfReadCodingUser = br1.read()) != -1) {
				Character ch1 = (char) bfReadCodingUser;
				bfReadUser += ch1;
			}
			// 关闭流
			br1.close();
			// 将字符串中有“null”，改为“;”
			String emptyString = bfReadUser.replaceAll("null", ";");
			// 以“;”为界，分割字符串
			String[] stringBfrTwoArray = emptyString.split(";");
			String newString = "";
			int y1 = 0;
			System.out.print("输入新密码：");
			String  newPassWord = sc.next();
			// 当passWorder长度为7时，进行删改操作
			if (newPassWord.length() == 7) {
				for (int i = 0; i < stringBfrOneArray.length; i++) {
					if (i == signCound) {
						stringBfrOneArray[i] = newPassWord;
					}
					newString += (stringBfrOneArray[i] + ";");
				}
				String[] stringBfrThreeArray = newString.split(";");
				for (int i = 0; i < stringBfrThreeArray.length; i++) {
					list2.add(stringBfrThreeArray[i]);
				}
				BufferedWriter user1 = new BufferedWriter(new FileWriter("user.txt"));
				for (int i7 = 0; i7 < list2.size(); i7++) {
					user1.write(list2.get(i7) + ";");
				}
				user1.close();
				System.out.println("密码修改完成！");
			}
		}
		else {
			System.out.println("查无此人！！");
		}
	}
}
