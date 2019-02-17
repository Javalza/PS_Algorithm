import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class baseBall {
	String number;
	int strike;
	int ball;

	public baseBall(String[] input) {
		this.number = input[0];
		this.strike = Integer.parseInt(input[1]);
		this.ball = Integer.parseInt(input[2]);
	}
}

public class ���ھ߱� {
	static baseBall[] b;

	public static void main(String[] args) throws IOException {
		// 1. 123 ~ 987 ���� ���� ,
		// 2. ���� �� S /B�� ���� ��ġ�ϴ��� Ȯ��
		// 3. ��ġ �� ��ȯ.
		// �� 123 11
		// 356 1 0 ���÷� 3�ڸ� �ƹ� ���ڸ� �����Ͽ� �� ������ 1 1�� 1 0 �� ������ �� ���� ��ġ ���� �����Ѵ�.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		b = new baseBall[n];
		for (int i = 0; i < n; i++) {
			b[i] = new baseBall(in.readLine().split(" ")); // sc.nextLine().split(" "); ���� ?
		}
		System.out.println(playGame());
	}

	public static int playGame() {
		int result = 0;
		String number = "";
		char[] c; // ������ ����
		char[] baseNum; // ���� ����
		int j = 0;
		for (int i = 123; i <= 987; i++) {
			number = String.valueOf(i);
			c = number.toCharArray();
			// �ϳ��� ���� ���� ���� ������� ���� �������� ����
			if (c[0] == c[1] || c[0] == c[2] || c[1] == c[2] || c[2] == c[0])
				continue;
			if (IsSame(c))
				result++;

		}
		return result;
	}

	public static boolean IsSame(char[] c) {
		int i, j;
		char[] baseNum; // �Է¹��� ��
		int result = 0;

		// 123~987 �� , �Է¹��� s,b�� ��ġ�ϴ��� �˻�
		for (j = 0; j < b.length; j++) {
			boolean chk = true;
			int strike = 0, ball = 0; // -===> ... s/b �����ؾ߉�
			baseNum = b[j].number.toCharArray();
			if (c[0] == baseNum[0])
				strike++;
			else if (c[0] == baseNum[1] || c[0] == baseNum[2])
				ball++;

			if (c[1] == baseNum[1])
				strike++;
			else if (c[1] == baseNum[0] || c[2] == baseNum[2])
				ball++;

			if (c[2] == baseNum[2])
				strike++;
			else if (c[2] == baseNum[0] || c[2] == baseNum[1])
				ball++;
			
			if (b[j].strike != strike || b[j].ball != ball) { // �������� ����� ���� �� �����Ƿ�
				return false;
			}
		
		}
		return true;
	}
}
