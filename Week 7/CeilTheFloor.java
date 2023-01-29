package Day_3;

public class CeilTheFloor {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 8, 9, 6, 5, 5, 6 };
		int n = arr.length;
		int x = 7;
		Pair resPair = getFloorAndCeil(arr, n, x);
		System.out.println(resPair);
	}

	static Pair getFloorAndCeil(int[] arr, int n, int x) {
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			if (ceil > arr[i] && x <= arr[i]) {
				ceil = arr[i];
			}
			if (floor < arr[i] && arr[i] <= x) {
				floor = arr[i];
			}
		}
		floor = Integer.MIN_VALUE == floor ? -1 : floor;
		ceil = Integer.MAX_VALUE == ceil ? -1 : ceil;
		return new Pair(floor, ceil);
	}

}

class Pair {
	int floor, ceil;

	public Pair() {
		this.floor = 0;
		this.ceil = 0;
	}

	public Pair(int floor, int ceil) {
		this.floor = floor;
		this.ceil = ceil;
	}

	@Override
	public String toString() {
		return this.floor + " " + this.ceil;
	}

}
