import java.util.Scanner;
//1003 피보나치 함수
public class test04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] a = new int[N];

		int[][] q = new int[42][2];

		q[0][0] = 1;
		q[0][1] = 0;
		q[1][0] = 0;
		q[1][1] = 1;
		for (int i = 0; i < 40; i++) {
			q[i + 2][0] = q[i + 1][0] + q[i][0];
			q[i + 2][1] = q[i + 1][1] + q[i][1];
		}
		for (int i = 0; i < N; i++) {
			a[i] = input.nextInt();
			System.out.println(q[a[i]][0] + " " + q[a[i]][1]);
		}
		input.close();
	}

	/*static int fibonacci(int n) {
		if (n == 0) {
			for (int i = 0; i < N; i++) {
				q[i][0]++;
				// System.out.println("(" + i + ",0)" + q[i][0]);
			}
			return 0;
		} else if (n == 1) {
			for (int i = 0; i < N; i++) {
				q[i][1]++;
				// System.out.println("(" + i + ",1)" + q[i][1]);
			}
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}*/
}
