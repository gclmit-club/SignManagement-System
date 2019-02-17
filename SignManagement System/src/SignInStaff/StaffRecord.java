package SignInStaff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import SignIn.TheSecondStep;

public class StaffRecord {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入姓名: (不超过五个字)");
		String staffName = sc.next();
		boolean judgeName = true;
		while (judgeName) {
			if ((staffName.length() > 0) && (staffName.length() <= 5)) {
				judgeName = false;
			} else {
				System.out.print("输入错误,重新输入:");
				staffName = sc.next();
				judgeName = true;
			}
		}
		System.out.print("生成ID:");
		// 创建BufferedReader类，读取data.txt中的信息
		BufferedReader dfr = new BufferedReader(new FileReader("data.txt"));
		// 创建一个int类型的数据(即read)用来接收txt中字符对应的编码表
		int read;
		String accept = "";
		while ((read = dfr.read()) != -1) {
			// 将接收到的编码表中的数字转变成char型，方便存入accept中
			Character ct = (char) read;
			accept += ct.toString();
		}
		// 将接收到的字符串以“,”为界分隔开，方便拿取想要的信息。
		String[] stringBfrOneArray = accept.split(",");
		int commaBound = 0;
		// 无逗号字符串
		String commaFreeString = "";
		// 分割accept时，将一组信息分成了四组，所以（string1.length / 4）得到本来的信息总数
		while (commaBound < stringBfrOneArray.length / 4) {
			// 取个人信息中的员工ID
			commaFreeString += stringBfrOneArray[commaBound * 4 + 1];
			commaBound++;
		}
		// 用“.”替换“员工ID:”，再删去“.”,得到ID
		commaFreeString = commaFreeString.replaceAll("员工ID:", ".");
		String[] stringBfrTwoArray = commaFreeString.split("\\.");
		// 无“.”字符串
		String noPauseString = "";
		for (int i3 = 0; i3 < stringBfrTwoArray.length; i3++) {
			noPauseString += stringBfrTwoArray[i3];
		}
		// 删去多余的空格键
		String[] stringBfrThreeArray = noPauseString.split("  ");
		int staffId = 0;
		if (stringBfrThreeArray.length == 1) {
			staffId = 1000;
			System.out.println(staffId);
		} else {
			for (int arrayReading = 0; arrayReading < stringBfrThreeArray.length; arrayReading++) {
				if (arrayReading == stringBfrThreeArray.length - 1) {
					staffId = Integer.parseInt(stringBfrThreeArray[arrayReading]) + 1;
					System.out.println(staffId);
				}
			}
		}
		System.out.print("输入学习方向:");
		String staffDirection = sc.next();
		System.out.print("输入性别:");
		String staffSexString = sc.next();
		char staffSex = 0;
		boolean judgeSex = true;
		while (judgeSex) {
			if (staffSexString.length() == 1) {
				staffSex = staffSexString.charAt(0);
				if ((staffSex == '男') || (staffSex == '女')) {
					judgeSex = false;
				} else {
					System.out.print("输入错误,重新输入:");
					staffSexString = sc.next();
					judgeSex = true;
				}
			} else {
				System.out.print("输入错误,重新输入:");
				staffSexString = sc.next();
				judgeSex = true;
			}
		}
		System.out.print("设置密码: (七位字符)");
		String staffPassWord = sc.next();
		boolean judgementPassWord = true;
		while (judgementPassWord) {
			if (staffPassWord.length() == 7) {
				judgementPassWord = false;
			} else {
				System.out.print("输入错误,重新输入:");
				judgementPassWord = true;
				staffPassWord = sc.next();
			}
		}
		Staff staffOne = new Staff(staffName, staffId, staffDirection, staffSex);
		BufferedWriter data = new BufferedWriter(new FileWriter("data.txt", true));
		data.write(staffOne.toString());
		BufferedWriter user = new BufferedWriter(new FileWriter("user.txt", true));
		user.write(staffPassWord+";");
		data.close();
		user.close();
		System.out.println("注册成功！");
	}
}
