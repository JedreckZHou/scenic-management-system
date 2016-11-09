import java.util.*;

class Vertex {
	public String name;
	public String description;
	public int popularity;
	public boolean hasLounge;
	public boolean hasToilet;
	
	public Vertex(String name) {
		this.name = name;
	}
	
	public boolean equals(String s) {
		if(name.equals(s))
			return true;
		return false;
	}
	
	public String toString() {
		return name;
	}
}

public class ScenicSpotGraph {			//景区景点图
	public static boolean isGraphCreated = false;
	public int verNum;					//景点数量
	public int edgNum;					//边数量
	public Vertex[] vers;
	public long[][] edgs;				//edgs[u][v]表示景点u、v之间的边，值代表距离distance
	
	/*创建景区景点图——邻接矩阵*/
	public void CreateScenicSpotGraph() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入顶点数和边数：");		
		verNum = sc.nextInt();
		edgNum = sc.nextInt();
		vers = new Vertex[verNum];
		edgs = new long[verNum][verNum];
		for(int i = 0; i < verNum; i++) {//初始化edgs[][]数组
			for(int j = 0; j < verNum; j++) {
				edgs[i][j] = 32767;
				if(i == j)
					edgs[i][j] = 0;
			}
		}
		
		System.out.println("			请输入各顶点的信息");
		System.out.print("请输入各顶点的名字：");
		for(int i = 0; i < verNum; i ++) {
			vers[i] = new Vertex(sc.next());
		}
		for(int i = 0; i < edgNum; i++) {
			System.out.print("请输入第" + (i + 1) + "条边的两个顶点以及该边的权值：");
			String firstVertexName = sc.next();
			String secondVertexName = sc.next();
			long edgeValue = sc.nextLong();
			boolean setSuccess = setEdgeValue(firstVertexName, secondVertexName, edgeValue);
			if(setSuccess == false) {
				i--;
			}
		}
		
		System.out.println("			创建成功！\n\n");
		isGraphCreated = true;
	}
	
	/*输出景区景点分布图——以邻接矩阵形式输出*/
	public void outputScenicSpotGraph() {
		Formatter f = new Formatter(System.out);
		
		String outputFormat = "%-8s";
		for(int i = 0; i < verNum; i++){
			outputFormat = outputFormat + " %-8s";
		}
		
		String outputHeader = "--- " + Arrays.toString(vers).replace("[", "").replace("]", "").replaceAll(",", "");
		f.format(outputFormat, outputHeader.split(" "));
		System.out.println();
		
		for(int i = 0; i < verNum; i++) {
			long[] temp = new long[verNum];
			for(int j = 0; j < verNum; j++) {
				temp[j] = edgs[i][j];
			}
			String outputBody = vers[i] + " " + Arrays.toString(temp).replace("[", "").replace("]", "").replaceAll(",", "");
			f.format(outputFormat, outputBody.split(" "));
			System.out.println();
		}
		
		System.out.println("\n");
	}  
	
	/*根据输入的景区的名字定位其在数组中的位置（下标）*/
	public int locateVer(String name) {
		for(int i = 0; i < verNum; i++) {
			if(vers[i].equals(name))
				return i;
		}
		return -1;
	}
	
	/*根据两个顶点名称及边的权值修改edgs[][]的值*/
	public boolean setEdgeValue(String firstVertexName, String secondVertexName, long edgeValue) {
		int firstVertexIndex = locateVer(firstVertexName);//获取顶点在vers[]中的下标
		int secondVertexIndex = locateVer(secondVertexName);

		if(firstVertexIndex != -1 && secondVertexIndex != -1) {
			edgs[firstVertexIndex][secondVertexIndex] = edgs[secondVertexIndex][firstVertexIndex] = edgeValue;	
			return true;
		}else if(firstVertexIndex != -1 && secondVertexIndex == -1) {
			System.out.println("输入错误：" + secondVertexName + " 不存在");
			return false;
		}else if(firstVertexIndex == -1 && secondVertexIndex != -1) {
			System.out.println("输入错误：" + firstVertexName + " 不存在");
			return false;
		}else{
			System.out.println("输入错误：" + firstVertexName + " 不存在     " + secondVertexName + " 不存在");
			return false;
		}
	}
	
	public static void main(String[] args) {
		ScenicSpotGraph ssg = new ScenicSpotGraph();
		ssg.CreateScenicSpotGraph();
		ssg.outputScenicSpotGraph();
	}
}
