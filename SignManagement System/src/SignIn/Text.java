package SignIn;

import java.io.IOException;
import java.util.Scanner;

import SignInChangePassWord.ChangePassWord;
import SignInRegister.Register;
import SignInStaff.StaffRecord;

public class Text {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean cycleJudgrment = true;
		while(cycleJudgrment) {
		System.out.println("1.员工登录 ; 2.员工注册 ; 3.密码修改 ; 4.退出");
		int beginPagina = 0;
		String beginPaginaString = sc.next();
		boolean judje = true;
		// 用try...catch...判断输入是否为数字
		while (judje) {
			try {
				beginPagina = Integer.parseInt(beginPaginaString);
				if ((beginPagina == 1) || (beginPagina == 2) ||(beginPagina == 3) ||(beginPagina == 4)) {
					judje = false;
				} else {
					System.out.print("输入错误！ 重新输入：");
					beginPaginaString = sc.next();
					judje = true;
				}
			} catch (NumberFormatException e) {
				System.out.print("输入错误！ 重新输入：");
				beginPaginaString = sc.next();
				judje = true;
			}
		}
		switch (beginPagina) {
		case 1:
			Register register = new Register();
			Register.main(args);
			cycleJudgrment = false;
			break;
		case 2:
			StaffRecord staffRecordOne = new StaffRecord();
			StaffRecord.main(args);
			cycleJudgrment = true;
			break;
		case 3:
			ChangePassWord changePassWord = new ChangePassWord();
			changePassWord.main(args);
			cycleJudgrment = true;
			break;
		case 4:
			System.out.println("退出！");
			cycleJudgrment = false;
			break;
		}
	}
}}
