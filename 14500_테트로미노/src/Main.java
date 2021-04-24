import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static boolean visit[][];
	public static int map[][];
	public static int ans,N,M;
	public static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		ans=0;
		for(int i=0;i<N;i++) {
			for(int j =0;j<M;j++) {
				map[i][j]= sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visit[i][j]=true;
				DFS(i,j,map[i][j],1);
				visit[i][j]=false;
			}
		}
		System.out.println(ans);
	}
	private static void DFS(int x, int y, int sum,int k) {
		if(k==4) {
			if(sum>ans) {
				ans=sum;
			}
		}else {
			for(int i=0;i<4;i++) {
				int tmpx = x+dir[i][0];
				int tmpy  = y + dir[i][1];
				if(inbound(tmpx,tmpy)&&!visit[tmpx][tmpy]) {
					visit[tmpx][tmpy]=true;
					DFS(x,y,sum+map[tmpx][tmpy],k+1);
					DFS(tmpx,tmpy,sum+map[tmpx][tmpy],k+1);
					visit[tmpx][tmpy]=false;
				}
				
			}
		}
		
	}
	private static boolean inbound(int tmpx, int tmpy) {
		if(tmpx>=0&&tmpy>=00&&tmpx<N&&tmpy<M)
			return true;
		return false;
	}
}
