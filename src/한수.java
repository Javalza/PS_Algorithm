package 문제;

import java.util.Scanner;

public class 한수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1000이하의 자릿수를 담을 배열 1000이상은 4자리가 필요한데 문제에선 1000이하라고 했으므로
		// 3개배열 가능하다. (다만 1000은 예외처리 필요)
		int arr[] = new int[3];
		int n = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (i < 100)
				count++;
			else if (i == 1000)
				break; // 예외처리
			else {
				int num = i;
				int k = 0 ; //이런 실수좀 그만해 시간 ...이거 하나 때문에..
				while (num > 0) {
					arr[k] = num % 10;
					num = num/10;
					k++;
				}
				if (isHansu(arr))
					count++;
			}
		}
		System.out.println(count);
	}

	static boolean isHansu(int[] arr) {
		return arr[0] - arr[1] == arr[1] - arr[2];
	}
}
