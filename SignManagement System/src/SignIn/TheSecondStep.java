package SignIn;

import java.io.IOException;
import java.util.Scanner;

import SignInDimission.Dimission;
import SignInPersonalDetails.PersonalDetails;
import SignInSwipe.Swipe;

public class TheSecondStep {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean cycleJudgement = true;
		System.out.println("**********");
		System.out.println("欢迎进入首页！");
		while (cycleJudgement) {
			System.out.print("1.签到 ; 2.员工离职 ; 3.个人信息 ;4,退出");
			int beginPagina = 0;
			String beginPaginaString = sc.next();
			boolean judje = true;
			// 用try...catch...判断输入是否为数字
			while (judje) {
				try {
					beginPagina = Integer.parseInt(beginPaginaString);
					if ((beginPagina == 1) || (beginPagina == 2) || (beginPagina == 3) || (beginPagina == 4)) {
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
				switch (beginPagina) {
				case 1:
					System.out.println("1.签到:");
					Swipe swipe = new Swipe();
					swipe.main(args);
					cycleJudgement = true;
					break;
				case 2:
					System.out.println("2.员工离职:");
					Dimission dimission = new Dimission();
					dimission.main(args);
					cycleJudgement = false;
					break;
				case 3:
					System.out.println("3.个人信息;");
					PersonalDetails personalDetails = new PersonalDetails();
					personalDetails.main(args);
					cycleJudgement = true;
					break;
				case 4:
					System.out.println("4.退出。");
					cycleJudgement = false;
					break;
				}
			}
		}
	}
}
