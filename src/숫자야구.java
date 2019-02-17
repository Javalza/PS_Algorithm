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

public class 숫자야구 {
	static baseBall[] b;

	public static void main(String[] args) throws IOException {
		// 1. 123 ~ 987 숫자 대입 ,
		// 2. 예시 중 S /B의 수와 일치하는지 확인
		// 3. 일치 수 반환.
		// 즉 123 11
		// 356 1 0 예시로 3자리 아무 숫자를 대입하여 두 조건의 1 1과 1 0 이 맞으면 그 수는 일치 수로 인정한다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		b = new baseBall[n];
		for (int i = 0; i < n; i++) {
			b[i] = new baseBall(in.readLine().split(" ")); // sc.nextLine().split(" "); 차이 ?
		}
		System.out.println(playGame());
	}

	public static int playGame() {
		int result = 0;
		String number = "";
		char[] c; // 막대입 숫자
		char[] baseNum; // 예시 숫자
		int j = 0;
		for (int i = 123; i <= 987; i++) {
			number = String.valueOf(i);
			c = number.toCharArray();
			// 하나라도 서로 같은 수가 있을경우 조건 만족하지 않음
			if (c[0] == c[1] || c[0] == c[2] || c[1] == c[2] || c[2] == c[0])
				continue;
			if (IsSame(c))
				result++;

		}
		return result;
	}

	public static boolean IsSame(char[] c) {
		int i, j;
		char[] baseNum; // 입력받은 수
		int result = 0;

		// 123~987 중 , 입력받은 s,b과 일치하는지 검사
		for (j = 0; j < b.length; j++) {
			boolean chk = true;
			int strike = 0, ball = 0; // -===> ... s/b 리셋해야됌
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
			
			if (b[j].strike != strike || b[j].ball != ball) { // 같지않은 경우의 수가 더 많으므로
				return false;
			}
		
		}
		return true;
	}
}
