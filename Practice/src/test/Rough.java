package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rough {

	public static void main(String[] args) {

		List<int[]> mainlist = new ArrayList<>();

		int[] a = { 10, 20 };
		int[] b = { 1, 2 };

		mainlist.add(a);
		mainlist.add(b);

		for (int[] element : mainlist) {
			for (int i : element) {
				System.out.print(i + ":");
			}
			System.out.println();
		}
		
		Collections.sort(mainlist,(a1, a2) -> {

			return (a1[0] * a1[0] + a1[1] * a1[1]) - (a2[0] * a2[0] + a2[1] * a2[1]);

		});

		Collections.sort(mainlist, new Comparator<int[]>() {

			@Override
			public int compare(int[] a1, int[] a2) {

				return (a1[0] * a1[0] + a1[1] * a1[1]) - (a2[0] * a2[0] + a2[1] * a2[1]);
			}
		});
		
		for (int[] element : mainlist) {
			for (int i : element) {
				System.out.print(i + ":");
			}
			System.out.println();
		}
		
		

		//Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
		
	}
}
