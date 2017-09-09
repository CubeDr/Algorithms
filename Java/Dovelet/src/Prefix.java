import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prefix {

	public static void main(String[] args) {
		String[] primaries;
		String S;
		boolean[] visited;
		int K;
		
		Input.init();
		ArrayList<String> pInput = new ArrayList<>(200);
		String in;
		while( !(in=Input.next()).equals(".") )
			pInput.add(in);
		primaries = pInput.toArray(new String[pInput.size()]);
		S = "";
		while( !(in=Input.next()).equals("") )
			S += in;
		visited = new boolean[S.length()+1];
		visited[0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		int cur, nextLength;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(String s : primaries) {
				nextLength = s.length();
				if(cur + nextLength > S.length()) continue;
				if(visited[cur + nextLength]) continue;
				if(!S.startsWith(s, cur)) continue;
				
				q.add(cur + nextLength);
				visited[cur + nextLength] = true;
			}
		}
		for(int i = visited.length-1; i>=0; i--) {
			if(visited[i]) {
				System.out.println(i);
				return;
			}
		}
	}

	static class Input {
		private static BufferedReader in;
		private static StringTokenizer tok;
		
		static void init() {
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = new StringTokenizer("");
		}
		
		static String next() {
			try {
				if(!tok.hasMoreTokens())
					tok = new StringTokenizer(in.readLine());
				
				return tok.nextToken();
			} catch (Exception e) { }
			return "";
		}
	}
}
