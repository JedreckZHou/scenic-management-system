import java.util.*;

class Vertex {//���㣨���㣩
	public String name;//����
	public String description;//���
	public int popularity;//��ӭ��
	public boolean hasLounge;//������Ϣ��
	public boolean hasToilet;//���޹���
	
	public Vertex(String name) {
		this.name = name;
	}
	
	public boolean equals(String s) {//���ݾ����������ж�
		if(name.equals(s))
			return true;
		return false;
	}
	
	public String toString() {
		return name;
	}
}

public class ScenicSpotGraph {//��������ͼ
	public static boolean isGraphCreated = false;
	public int verNum;//��������
	public int edgNum;//������
	public Vertex[] vers;
	public long[][] edgs;//edgs[u][v]��ʾ����u��v֮��ıߣ�ֵ�������distance
	
	public void CreateScenicSpotGraph() {//������������ͼ�����ڽӾ���
		Scanner sc = new Scanner(System.in);
		System.out.println("�����붥�����ͱ�����");
		
		verNum = sc.nextInt();
		edgNum = sc.nextInt();
		vers = new Vertex[verNum];
		edgs = new long[verNum][verNum];
		
		System.out.println("					��������������Ϣ");
		System.out.println("���������������֣�");
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
			System.out.println("�������" + (i + 1) + "���ߵ����������Լ��ñߵ�Ȩֵ��");
			int u = locateVer(sc.next());//��ȡ������vers[]�е��±�
			int v = locateVer(sc.next());
			
			if(u < verNum && u > -1 && v < verNum && v > -1){
				edgs[u][v] = edgs[v][u] = sc.nextLong();//����Ӧ�߸���Ȩֵ				
			}else{
				System.out.println("������Ķ��㲻��ȷ");
			}
		}
		
		isGraphCreated = true;
	}
	
	public void outputScenicSpotGraph() {//�����������ֲ�ͼ�������ڽӾ�����ʽ���
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
	
	public int locateVer(String name) {//���ݾ��������ֶ�λ���������е�λ��
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
