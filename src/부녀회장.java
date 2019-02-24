import java.util.Arrays;
import java.util.Scanner;

public class 부녀회장 {
	public static void main(String[] args) {
		int[][] apt = new int[15][15];
		int i, j;
		for (j = 0; j < 15; j++)
			apt[0][j] = j + 1;

		for (i = 1; i < 15; i++) // 1층 ~ n층 첫 호의수는 고정
			for (j = 0; j < 15; j++)
				for (int k = 0; k <= j; k++)
					apt[i][j] += apt[i - 1][k];

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] output = new int[n][2];
		int floor = 0;
		int ho = 0;
		for (i = 0; i < n; i++) {
			floor = sc.nextInt();
			ho = sc.nextInt();
			output[i][0] = floor;
			output[i][1] = ho;
		}
		for (i = 0; i < n; i++)
			System.out.println(apt[output[i][0]][output[i][1]-1]);
	}
}
