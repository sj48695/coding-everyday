import java.util.Scanner;
//7576 �丶��
public class test01 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int[][] q = new int[1000050][2];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int head = 0, tail = 0;
		int x, y;
		int M, N;
		int i, j;
		N = input.nextInt();
		M = input.nextInt();
		int[][] map = new int[1000][1000];
		int[][] check = new int[1000][1000];

		for (i = 0; i <= N + 1; i++) {
			for (j = 0; j <= M + 1; j++) {
				map[i][j] = -1;
				check[i][j] = 0;// �ʱ�ȭ
			}
		}

		for (i = 1; i <= N; i++) {
			for (j = 1; j <= M; j++) {
				map[i][j] = input.nextInt();// �Է�
				if (map[i][j] == 1) {
					q[tail][0] = i;
					q[tail][1] = j; // �Ź� ���� �ֵ��� ť�� �����Ѵ�.
					tail++;
				}
			}
		}

		while (head < tail) {
			x = q[head][0];
			y = q[head][1];
			head++;
			for (i = 0; i < 4; i++) {
				if (x + dx[i] <= N && y + dy[i] <= M && x + dx[i] >= 1 && y + dy[i] >= 1
						&& map[x + dx[i]][y + dy[i]] == 0) {
					map[x + dx[i]][y + dy[i]] = 1;
					check[x + dx[i]][y + dy[i]] = check[x][y] + 1; // ���� �ɸ��� �� check �Ѵ�.
					q[tail][0] = x + dx[i];
					q[tail][1] = y + dy[i]; // �̹��� ���� �ֵ��� ť�� �����Ѵ�.
					tail++;
				}
			}
		}
		int days = 0, count = 0;
		for (i = 1; i <= N; i++) {
			for (j = 1; j <= M; j++) {
				if (days < check[i][j]) {
					days = check[i][j];
				}
				if (map[i][j] == 0)
					count = 1;
			}
		}
		if (count == 1)
			System.out.println("-1");
		else
			System.out.println("�ּҳ�¥ : " + days);

		// TODO Auto-generated method stub
		input.close();
	}
}
