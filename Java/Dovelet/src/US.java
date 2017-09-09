import java.util.Scanner;

public class US {
	
	private static int calculateFrom(int[] arr, int[] up, int from) {
		if(up[from] != 0) return up[from];
		
		int max = 0;
		int length;
		
		for(int i=from-1; i>=0; i--) {
			if(arr[i] >= arr[from]) continue;
			length = calculateFrom(arr, up, i);
			if(length > max) max = length;
		}
		
		return up[from] = max+1;
	}
	
	private static void reconstruct(int[] arr, int[] up, int idx) {
		
		if(up[idx] == 1) {
			System.out.print(arr[idx] + " ");
			return;
		}
		
		for(int i=idx-1; i>=0; i--) {
			if(arr[i] < arr[idx] && up[i] == up[idx]-1) {
				reconstruct(arr, up, i);
				break;
			}
		}
		
		System.out.print(arr[idx] + " ");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = in.nextInt();
		in.close();
		
		int[] up = new int[N];
		
		int max = 0, maxIdx=0;
		int length;
		for(int i=arr.length-1; i>=0; i--) {
			length = calculateFrom(arr, up, i);
			if(max < length) {
				max = length;
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		reconstruct(arr, up, maxIdx);
	}
}
