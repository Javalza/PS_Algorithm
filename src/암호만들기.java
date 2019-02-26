package 문제;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {
	static int depth;
	static int n; // 만들 수 있는 문자 길이. (총 depth 길이)
	static int count; // 올 수 있는 문자 수
	static char[] arr = new char[15];
	static char[] seleceted = new char[15]; // 최대 가질 수 있는문자 15
	static int[] flag = new int[15];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		n = Integer.parseInt(s[0]);
		count = Integer.parseInt(s[1]);

		String str = sc.nextLine(); // 최대 count 만큼만 입력 받기.
		seleceted = str.toCharArray();

		Tree(0);
	}

	public static void Tree(int depth) {
		// 서로 다른 문자를 4글자를 선택한다.
		// 이전 문자의 아스키코드값보다 다음 아스키코드값이 항상 커야하며 동일문자가 올 수 없음.
		if (depth == n) { // 출력
			String answer = String.valueOf(arr);
			for (int i = 0; i < depth; i++) {
				if (answer.charAt(i) == 'a' || answer.charAt(i) == 'e' || answer.charAt(i) == 'i'
						|| answer.charAt(i) == 'o' || answer.charAt(i) == 'i') {
					System.out.println(answer); //모음이 하나라도 포함 된 경우 출력  
					break; 
				}
			}
			return;
		}
		for (int i = 0; i < count; i++) {
			if (flag[i] == 1)
				continue;
			if (depth >= 1) {
				if (arr[depth - 1] - 'a' > seleceted[i] - 'a')
					continue; // 이전 문자가 더 큰경우 조건 위배
			}
			flag[i] = 1; // 동일문자 선택 제거 .
			arr[depth] = seleceted[i]; // 선택된 문자
			Tree(depth + 1);
			flag[i] = 0;
		}

	}

}
