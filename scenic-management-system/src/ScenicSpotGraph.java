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

public class ScenicSpotGraph {			//��������ͼ
	public static boolean isGraphCreated = false;
	public int verNum;					//��������
	public int edgNum;					//������
	public Vertex[] vers;
	public long[][] edgs;				//edgs[u][v]��ʾ����u��v֮��ıߣ�ֵ�������distance
	
	/*������������ͼ�����ڽӾ���*/
	public void CreateScenicSpotGraph() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����붥�����ͱ�����");		
		verNum = sc.nextInt();
		edgNum = sc.nextInt();
		vers = new Vertex[verNum];
		edgs = new long[verNum][verNum];
		for(int i = 0; i < verNum; i++) {//��ʼ��edgs[][]����
			for(int j = 0; j < verNum; j++) {
				edgs[i][j] = 32767;
				if(i == j)
					edgs[i][j] = 0;
			}
		}
		
		System.out.println("			��������������Ϣ");
		System.out.print("���������������֣�");
		for(int i = 0; i < verNum; i ++) {
			vers[i] = new Vertex(sc.next());
		}
		for(int i = 0; i < edgNum; i++) {
			System.out.print("�������" + (i + 1) + "���ߵ����������Լ��ñߵ�Ȩֵ��");
			String firstVertexName = sc.next();
			String secondVertexName = sc.next();
			long edgeValue = sc.nextLong();
			boolean setSuccess = setEdgeValue(firstVertexName, secondVertexName, edgeValue);
			if(setSuccess == false) {
				i--;
			}
		}
		
		System.out.println("			�����ɹ���\n\n");
		isGraphCreated = true;
	}
	
	/*�����������ֲ�ͼ�������ڽӾ�����ʽ���*/
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
	
	/*��������ľ��������ֶ�λ���������е�λ�ã��±꣩*/
	public int locateVer(String name) {
		for(int i = 0; i < verNum; i++) {
			if(vers[i].equals(name))
				return i;
		}
		return -1;
	}
	
	/*���������������Ƽ��ߵ�Ȩֵ�޸�edgs[][]��ֵ*/
	public boolean setEdgeValue(String firstVertexName, String secondVertexName, long edgeValue) {
		int firstVertexIndex = locateVer(firstVertexName);//��ȡ������vers[]�е��±�
		int secondVertexIndex = locateVer(secondVertexName);

		if(firstVertexIndex != -1 && secondVertexIndex != -1) {
			edgs[firstVertexIndex][secondVertexIndex] = edgs[secondVertexIndex][firstVertexIndex] = edgeValue;	
			return true;
		}else if(firstVertexIndex != -1 && secondVertexIndex == -1) {
			System.out.println("�������" + secondVertexName + " ������");
			return false;
		}else if(firstVertexIndex == -1 && secondVertexIndex != -1) {
			System.out.println("�������" + firstVertexName + " ������");
			return false;
		}else{
			System.out.println("�������" + firstVertexName + " ������     " + secondVertexName + " ������");
			return false;
		}
	}
	
	public static void main(String[] args) {
		ScenicSpotGraph ssg = new ScenicSpotGraph();
		ssg.CreateScenicSpotGraph();
		ssg.outputScenicSpotGraph();
	}
}
