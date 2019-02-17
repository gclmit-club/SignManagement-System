package SignInRegister;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import SignIn.TheSecondStep;
import SingInAuthCode.AuthCode;

public class Register {
	public static String ID(String ID) {
		return ID;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean cyclyJudgemment = true;
		BufferedWriter id = new BufferedWriter(new FileWriter("ID.txt"));
		BufferedWriter direction = new BufferedWriter(new FileWriter("Directions.txt"));
		while (cyclyJudgemment) {
			System.out.print("请输入ID：");
			String ids = sc.next();
			id.write(ids);
			id.close();
			System.out.print("请输入密码：");
			String directions = sc.next();
			direction.write(directions);
			direction.close();
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
			BufferedReader f = new BufferedReader(new FileReader("user.txt"));
			int y;
			ArrayList<String> array3 = new ArrayList<>();
			while ((y = f.read()) != -1) {
				Character cd = (char) y;
				array3.add(cd.toString());
			}
			String poin1 = "";
			for (int ft = 0; ft < array3.size(); ft++) {
				poin1 += array3.get(ft);
			}
			String[] ji = poin1.split(";");
			String ID;
			String DT;
			int sd = 0;
			for (int d = 0; d < stringBfrFourArray.length; d++) {
				ID = stringBfrFourArray[d];
				// 当输入的ID和密码都对是，输出"登录成功！"，否者提示出现错误
				if (ids.equals(ID)) {
					DT = ji[d - 1];
					if (directions.equals(DT)) {
						AuthCode authCode = new AuthCode();
						authCode.main(args);
						System.out.println("登录成功！");
						sd = 1;
						cyclyJudgemment = false;
						TheSecondStep theSecondStep = new TheSecondStep();
						theSecondStep.main(args);
					}
					if (sd != 1) {
						System.out.println("ID或密码错误！");
						cyclyJudgemment = true;
					}
				}
			}
		}
	}
}
