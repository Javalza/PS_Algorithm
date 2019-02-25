package 문제;

import java.util.Arrays;

public class 순열 {
	static int depth;
	static int[] flag = new int[5];
	static int[] selected = new int[3];
	static int N = 4;	//1~4숫자. 
	static void fullTree(int depth){
		if(depth ==3 ) { //3자리 완성 된 경우 
			System.out.println(Arrays.toString(selected));
			return;
		}
		for(int i=1;i<=N;i++) {
			if(flag[i]==1) continue;
			flag[i] =1;
			
			selected[depth] =i;
			fullTree(depth+1);
			flag[i]=0;
		}
	}
	public static void main(String[] args) {
		// 1~4숫자를 3자리 중복없는 숫자로 출력.
		fullTree(0);
	}

}
