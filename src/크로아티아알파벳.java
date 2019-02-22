import java.util.Scanner;

public class 크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String input =sc.nextLine();
		
		for(int i=0;i<8;i++)
			input = input.replace(croatia[i], "a");
		System.out.println(input);
	}
}
