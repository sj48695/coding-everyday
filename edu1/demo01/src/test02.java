import java.util.*;
//2156 포도주 시식
public class test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] grape = new int[10001];
		int[] drink = new int[10001];// 마신 포도주
		for (int i = 1; i <= N; i++) {
			grape[i] = input.nextInt();
		}
		drink[0] = 0;
		drink[1] = grape[1];
		drink[2] = drink[1] + grape[2];
		for (int i = 3; i <= N; i++) {
			drink[i] = Max(drink[i - 3] + grape[i - 1] + grape[i], drink[i - 1], drink[i - 2] + grape[i]);
		}
		System.out.println(drink[N]);
		input.close();
	}

	private static int Max(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (j > k) {
			if (i > j)
				return i;
			else
				return j;

		} else {
			if (i > k)
				return i;
			else
				return k;
		}
	}

}
