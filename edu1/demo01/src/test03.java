import java.util.Scanner;
//1525 ∆€¡Ò
public class test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[][] a = new int[3][3];
		int[] su = new int[9];
		int[][] init = new int[3][3];
		int[] x = { -1, 0, +1, 0 };
		int[] y = { 0, -1, 0, +1 };
		int swap = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = input.nextInt();

				su[(3 * i) + j] = a[i][j];
			}
		}
		for (int i = 0; i < 9; i++) {
			if (su[i] == 0) {
				swap = su[i];
				su[i] = su[8];
				su[8] = swap;
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = i; j < 8; j++) {

				if (su[i] > su[j]) {
					swap = su[j];
					su[j] = su[i];
					su[i] = swap;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				init[i][j] = su[(3 * i) + j];
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (a[i][j] == 0) {
					a[i-x[i]][j] =;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(init[i][j] + " ");
			}
			System.out.println();
		}
		input.close();
	}

}
