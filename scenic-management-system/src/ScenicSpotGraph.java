import java.util.*;

class Vertex {//景点（顶点）
	public String name;//名称
	public String description;//简介
	public int popularity;//欢迎度
	public boolean hasLounge;//有无休息区
	public boolean hasToilet;//有无公厕
	
	public Vertex(String name) {
		this.name = name;
	}
	
	public boolean equals(String s) {//根据景区名字来判断
		if(name.equals(s))
			return true;
		return false;
	}
	
	public String toString() {
		return name;
	}
}

public class ScenicSpotGraph {//景区景点图
	public static boolean isGraphCreated = false;
	public int verNum;//景点数量
	public int edgNum;//边数量
	public Vertex[] vers;
	public long[][] edgs;//edgs[u][v]表示景点u、v之间的边，值代表距离distance
	
	public void CreateScenicSpotGraph() {//创建景区景点图——邻接矩阵
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入顶点数和边数：");
		
		verNum = sc.nextInt();
		edgNum = sc.nextInt();
		vers = new Vertex[verNum];
		edgs = new long[verNum][verNum];
		
		System.out.println("					请输入各顶点的信息");
		System.out.println("请输入各顶点的名字：");
		for(int i = 0; i < verNum; i ++) {
			vers[i] = new Vertex(sc.next());
		}
		
		for(int i = 0; i < verNum; i++) {
			for(int j = 0; j < verNum; j++) {
				edgs[i][j] = 32767;
				if(i == j)
					edgs[i][j] = 0;
			}
		}
		
		for(int i = 0; i < edgNum; i++) {
			System.out.println("请输入第" + (i + 1) + "条边的两个顶点以及该边的权值：");
			int u = locateVer(sc.next());//获取顶点在vers[]中的下标
			int v = locateVer(sc.next());
			
			if(u < verNum && u > -1 && v < verNum && v > -1){
				edgs[u][v] = edgs[v][u] = sc.nextLong();//给对应边赋上权值				
			}else{
				System.out.println("您输入的顶点不正确");
			}
		}
		
		isGraphCreated = true;
	}
	
	public void outputScenicSpotGraph() {//输出景区景点分布图——以邻接矩阵形式输出
		Formatter f = new Formatter(System.out);
		
		String s = "%-8s";
		for(int i = 0; i < verNum; i++){
			s = s + " %-8s";
		}
		
		f.format(s, ("--- " + Arrays.toString(vers).replace("[", "").replace("]", "").replaceAll(",", "")).split(" "));
		System.out.println();
		
		for(int i = 0; i < verNum; i++) {
			long[] temp = new long[verNum];
			for(int j = 0; j < verNum; j++) {
				temp[j] = edgs[i][j];
			}
			String tempS = vers[i] + " " + Arrays.toString(temp).replace("[", "").replace("]", "").replaceAll(",", "");
			f.format(s, tempS.split(" "));
			System.out.println();
		}
	}  
	
	public int locateVer(String name) {//根据景区的名字定位其在数组中的位置
		for(int i = 0; i < verNum; i++) {
			if(vers[i].equals(name))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ScenicSpotGraph ssg = new ScenicSpotGraph();
		ssg.CreateScenicSpotGraph();
		ssg.outputScenicSpotGraph();
	}
}
