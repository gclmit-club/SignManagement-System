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
		System.out.print("������������");
		String name = sc.next();
		System.out.print("������ѧϰ����");
		String direction = sc.next();
		System.out.print("�������Ա�");
		char sex = sc.next().charAt(0);
		System.out.print("����ID��");
		int id = sc.nextInt();
		// ����Staff�࣬����������String1����
		Staff staffTwo = new Staff(name, id, direction, sex);
		String staffTwoString1 = staffTwo.toString1();
		// ����BufferedReader��ȡ"data.txt"�е���Ϣ
		BufferedReader bf = new BufferedReader(new FileReader("data.txt"));
		int bfReadCodingDate = 0;
		String bfReadDate = "";
		List<String> listNewDate = new ArrayList();
		while ((bfReadCodingDate = bf.read()) != -1) {
			Character ch = (char) bfReadCodingDate;
			bfReadDate += ch.toString();
		}
		// �ر���
		bf.close();
		// �ԡ�����Ϊ�磬�ָ��ַ���bfReadDate���洢��������
		String[] noPeriodString = bfReadDate.split("��");
		int i5 = 0;
		int h = 0;
		for (int i = 0; i < noPeriodString.length; i++) {
			// ���������Ϣ��"data.txt"һ��ʱ�������˴�ѭ��
			if (staffTwoString1.equals(noPeriodString[i])) {
				// ��ס���ǵڼ�����Ȼ�����ֱ��ɾ����
				i5 = i;
				h = 1;
				continue;
			}
			listNewDate.add(noPeriodString[i] + "��");
		}
		// ��ȡ"user.txt"�ڵ�����
		BufferedReader bfrUser = new BufferedReader(new FileReader("user.txt"));
		int bfReadCodingUser;
		String bfReadUser = "";
		List listNewUser = new ArrayList();
		while ((bfReadCodingUser = bfrUser.read()) != -1) {
			Character ch1 = (char) bfReadCodingUser;
			bfReadUser += ch1;
		}
		// �ر���
		bfrUser.close();
		// ���ַ������С�null������Ϊ��;��
		String emptyString = bfReadUser.replaceAll("null", ";");
		// �ԡ�;��Ϊ�磬�ָ��ַ���
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
		// ���������Ϣ����ʱ����ɾ�������Ϣ����д��txt�У��������"��Ϣ���������,�����µ�¼"
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
			System.out.println("��Ϣ���������,�����µ�¼");
			cyclyJudgemment = true;
		}
		System.out.println("�ټ�!");
		cyclyJudgemment = false;
	} }
}
