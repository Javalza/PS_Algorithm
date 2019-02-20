package 문제;

public class 셀프넘버 {

	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			if(arr[i]==true) continue;
			d(arr,i+i/1000+(i/100)%10+(i/10)%10+i%10);
		}
		for(int i=1;i<=10000;i++)
			if(!arr[i]) System.out.println(i); //셀프넘버
	}
	static void d(boolean arr[],int n) {
		if(n>10000) return;
		arr[n] =true;
		d(arr,n+n/1000+(n/100)%10+(n/10)%10+n%10); //천,백,십,일 자리 수로 나눈다.
	}

}
