package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;

public class 탑 {
	static boolean isNumberic(String[] str) {
		//숫자인경우 false를 리턴해준다. 
		int n;
		try {
			for(int i=0;i<str.length;i++) {
				 n = Integer.parseInt(str[i]);
				 if(n > 100000000) return true;
			}
		} catch (NumberFormatException e) {
				return true; //숫자가 아니다. 
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		Stack<Integer> data = new Stack<>();
		Stack<Integer> output = new Stack<>();
		int tmp = 0;
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		do {
			n = sc.nextInt();
		}while(n<1 || n >500000);
		String[] str= {"",};
		
		do {
			str = br.readLine().split(" ");	
		}while(str.length<n || str.length > n || isNumberic(str));
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < str.length; i++)
			data.push(Integer.parseInt(str[i]));
	
		while (!data.empty()) {
			tmp = data.pop();
			// 예외처리
			if (data.size() == 0) {
				output.push(0); // 스택에 전 데이터가 없는 경우(레이저를 받을 수 없는경우임)
				break;
			}
			if (tmp < data.elementAt(data.size() - 1)) { // 스택 전 데이터가 큰 경우
				output.push(data.size());
			} else { // 스택 전 데이터가 작은경우
				boolean found = false;
				for (int i = data.size() - 1; i >= 0; i--) {
					if (data.elementAt(i) > tmp) {
						output.push(i + 1);
						found = true;
						break;
					}
				}
				if(!found) output.push(0);
			}
		}
		while (!output.empty())
			System.out.print(output.pop() + " ");
	}

}
