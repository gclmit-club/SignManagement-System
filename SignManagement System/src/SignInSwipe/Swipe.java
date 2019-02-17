package SignInSwipe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import SignInRegister.Register;

public class Swipe {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader bfrId = new BufferedReader(new FileReader("ID.txt"));
		int idInt = 0;
		String ids = "" ;
		while ((idInt = bfrId.read()) !=-1) {
			Character ch = (char) idInt;
			ids += ch.toString();
		}
		bfrId.close();
		BufferedReader bfrdirection = new BufferedReader(new FileReader("Directions.txt"));
		int directionInt = 0;
		String directions = "" ;
		while ((directionInt = bfrdirection.read()) !=-1) {
			Character ch = (char) directionInt;
			directions += ch.toString();
		}
		bfrdirection.close();
		// 创建BufferedReader类读取"data.txt"
		BufferedReader bfr = new BufferedReader(new FileReader("data.txt"));
		int bfReadCoding;
		String bfReadDate = "";
		while ((bfReadCoding = bfr.read()) != -1) {
			Character chd = (char) bfReadCoding;
			bfReadDate += chd;
		}
		// 以“。”为界分割字符串
		String[] stringBfrOneArray = bfReadDate.split("。");
		String noPeriodString = "";
		for (int i = 0; i < stringBfrOneArray.length; i++) {
			noPeriodString += stringBfrOneArray[i];
		}
		// 去除字符串中的空格
		String[] stringBfrTwoArray = noPeriodString.split("  ");
		String emptyString = "";
		for (int i = 0; i < stringBfrTwoArray.length; i++) {
			emptyString += stringBfrTwoArray[i];
		}
		// 以“,”为界分割字符串
		String[] stringBfrThreeArray = emptyString.split(",");
		String commaFreeString = "";
		// 通过以下方法，从信息中单独拿出ID
		for (int i = 0; i < stringBfrThreeArray.length / 4; i++) {
			commaFreeString = commaFreeString + stringBfrThreeArray[i * 4 + 1];
		}
		commaFreeString = commaFreeString.replace("员工ID:", ".");
		String[] stringBfrFourArray = commaFreeString.split("\\.");
		// 读取“user.txt”中的数据
		BufferedReader bfUser = new BufferedReader(new FileReader("user.txt"));
		int countUser;
		String userString = "";
		while ((countUser = bfUser.read()) != -1) {
			Character cd = (char) countUser;
			userString += cd;
		}
		String[] noSemicolonStringArray = userString.split(";");
		String ID;
		String DT;
		int sd = 0;
		// 当输入的ID和密码都对是，输出"登录成功！"，否者提示出现错误
		for (int i = 0; i < stringBfrFourArray.length; i++) {
			ID = stringBfrFourArray[i];
			if (ids.equals(ID)) {
				DT = noSemicolonStringArray[i - 1];
				if (directions.equals(DT)) {
					System.out.println("**********************************");
					sd = 1;
					// 初始化 Date 对象
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					BufferedWriter signIn = new BufferedWriter(new FileWriter("signIn.txt", true));
					signIn.write(stringBfrOneArray[i - 1] + "   " + "签到时间：" + sdf.format(date));
					signIn.newLine();
					signIn.close();
					System.out.println(sdf.format(date) + "签到成功！");
					System.out.println("**********************************");
				}
				if (sd != 1) {
					System.out.println("ID或密码错误！");
				}
			}
		}
	}
}
