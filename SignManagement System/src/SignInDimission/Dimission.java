package SignInDimission;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SignInStaff.Staff;

public class Dimission {
	public static void main(String[] args) throws IOException {
		boolean cyclyJudgemment = true;
		while(cyclyJudgemment) {
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
		// 以“。”为界，分割字符串bfReadDate，存储进数组中
		String[] noPeriodString = bfReadDate.split("。");
		int i5 = 0;
		int h = 0;
		for (int i = 0; i < noPeriodString.length; i++) {
			// 当输入的信息与"data.txt"一致时，跳过此次循环
			if (staffTwoString1.equals(noPeriodString[i])) {
				// 记住这是第几个，然后可以直接删密码
				i5 = i;
				h = 1;
				continue;
			}
			listNewDate.add(noPeriodString[i] + "。");
		}
		// 读取"user.txt"内的密码
		BufferedReader bfrUser = new BufferedReader(new FileReader("user.txt"));
		int bfReadCodingUser;
		String bfReadUser = "";
		List listNewUser = new ArrayList();
		while ((bfReadCodingUser = bfrUser.read()) != -1) {
			Character ch1 = (char) bfReadCodingUser;
			bfReadUser += ch1;
		}
		// 关闭流
		bfrUser.close();
		// 将字符串中有“null”，改为“;”
		String emptyString = bfReadUser.replaceAll("null", ";");
		// 以“;”为界，分割字符串
		String[] str4 = emptyString.split(";");
		String str5 = "";
		int y = 0;
		for (int i = 0; i < str4.length; i++) {
			if (i == i5) {
				y = 1;
				continue;
			}
			str5 += (str4[i] + ";");
		}
		String[] str6 = str5.split(";");
		for (int i = 0; i < str6.length; i++) {
			listNewUser.add(str6[i]);
		}
		// 当密码和信息都对时，将删除后的信息重新写入txt中，否则输出"信息或密码错误,请重新登录"
		if ((y == 1) && (h == 1)) {
			BufferedWriter data1 = new BufferedWriter(new FileWriter("data.txt"));
			for (int i3 = 0; i3 < listNewDate.size(); i3++) {
				data1.write(listNewDate.get(i3).toString());
			}
			data1.close();
			BufferedWriter user1 = new BufferedWriter(new FileWriter("user.txt"));
			for (int i7 = 0; i7 < listNewUser.size(); i7++) {
				user1.write(listNewUser.get(i7) + ";");
			}
			user1.close();
		} else {
			System.out.println("信息或密码错误,请重新登录");
			cyclyJudgemment = true;
		}
		System.out.println("再见!");
		cyclyJudgemment = false;
	} }
}
