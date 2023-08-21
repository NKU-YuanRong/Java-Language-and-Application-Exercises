package Free_Test;

import java.util.Arrays;

public class TestIntArray {
	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 11;
		a[1] = 1;
		a[4] = 33;
		a[3] = 3;
		a[2] = 7;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
