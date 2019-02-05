import java.util.Scanner;

//사칙연산
public class test00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.next());
		int num_5 = -1;
		int num_3 = 0;
		if (N % 5 == 0) {
			num_5 = N / 5;
			System.out.println(num_5);
		} else {
			for (int i = N / 5; i >= 0; i--) {
				if ((N - 5 * i) % 3 == 0) {
					num_5 = i;
					num_3 = (N - 5 * i) / 3;
					break;
				}
			}
			System.out.println(num_5 + num_3);

		}
		input.close();
	}

}
