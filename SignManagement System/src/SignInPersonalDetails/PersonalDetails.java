package SignInPersonalDetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
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
	BufferedReader bfrId = new BufferedReader(new FileReader("ID.txt"));
	int idInt = 0;
	String ids = "" ;
	while ((idInt = bfrId.read()) !=-1) {
		Character ch = (char) idInt;
		ids += ch.toString();
	}
	bfrId.close();
	int t = 0;
	for (int i = 0; i < stringBfrFourArray.length; i++) {
		if (ids.equals(stringBfrFourArray[i])) {
			t = 1;
			System.out.print("您的个人信息:");
			System.out.println(stringBfrOneArray[i - 1]);
		}
	}
	if (t != 1) {
		System.out.println("输入错误！");
	}
}
}

