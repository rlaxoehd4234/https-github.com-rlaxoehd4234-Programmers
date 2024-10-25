import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[] mainArr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean validArr(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int n, int m, int depth) {
		if(depth == m) {
			if(validArr(arr)) {
				for(int value : arr) {
					sb.append(value).append(' ');
				}
				sb.append('\n');
			}
			return;
		}
		for(int i = 0; i < mainArr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = mainArr[i];
				dfs(n, m, depth+1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		mainArr = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			mainArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(mainArr);
		dfs(n,m,0);
		System.out.println(sb);

	}

}
