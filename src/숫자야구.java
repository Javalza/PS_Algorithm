package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

//입력으로 주어진 수가 정답인지 확인 
//S/B이 전체수와 일치하는지 확인한다. 
//입력의 조건이 모두 맞는경우 조건의 수가 될 수 있음.
class baseball {
	public String number;
	public int strike;
	public int ball;

	public baseball(String[] str) {
		this.number = str[0];
		this.strike = Integer.parseInt(str[1]);
		this.ball = Integer.parseInt(str[2]);
	}
}

public class 숫자야구 {
	private static baseball b[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0, i;
		do {
			try {
				n = sc.nextInt(); // 물음과 질문 수
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in); // Scanner 함수 초기화 (안할 경우 무한루프 발
			}
		} while (n < 1 || n > 100);
		// sc.nextLine(); nextInt() 입력받은후 nextLine()하지 않으면 에러 발생 (SCanner함수 이용시)
		b = new baseball[n];

		String[] s;
		boolean t = false;
		int num1, num2, num3;
		for (i = 0; i < n; i++) {
			// b[i] = new baseball(sc.nextLine().split(" "));
			do {
				 t = false;
				s = br.readLine().split(" ");
				try {
					num1 = Integer.parseInt(s[0]);
					num2 = Integer.parseInt(s[2]);
					num3 = Integer.parseInt(s[2]);
				} catch (NumberFormatException e) {
					t= true;
					// = new BufferedReader(new InputStreamReader(System.in));
				}
			} while (s.length < 3 || s.length > 3 || t);
			b[i] = new baseball(s); 
		}
		System.out.println(playGame());
	}

	static int playGame() {
		int result = 0;
		// 중복없는 3자리 수 123 ~ 987 대입시작
		for (int i = 123; i <= 987; i++) {
			boolean isTrue = true;
			String number = String.valueOf(i);
			char[] BFnum = number.toCharArray();
			// 서로다른 3자리 수 조건을 만족해야한다.
			if (BFnum[0] == BFnum[1] || BFnum[0] == BFnum[2] || BFnum[1] == BFnum[2])
				continue;

			for (int j = 0; j < b.length; j++) {
				int strike = 0;
				int ball = 0;

				if (BFnum[0] == b[j].number.charAt(0))
					strike++;
				else if (BFnum[0] == b[j].number.charAt(1) || BFnum[0] == b[j].number.charAt(2))
					ball++;

				if (BFnum[1] == b[j].number.charAt(1))
					strike++;
				else if (BFnum[1] == b[j].number.charAt(0) || BFnum[1] == b[j].number.charAt(2))
					ball++;

				if (BFnum[2] == b[j].number.charAt(2))
					strike++;
				else if (BFnum[2] == b[j].number.charAt(0) || BFnum[2] == b[j].number.charAt(1))
					ball++;

				// 하나라도 틀릴경우 다른 랜덤 숫자부터 시작한다.(입력받은 조건과 맞아야 하므로)
				if (strike != b[j].strike || ball != b[j].ball) {
					isTrue = false;
					break;
				}
			}
			if (isTrue)
				result++;

		}
		return result;
	}
}
