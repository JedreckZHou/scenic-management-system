import java.util.*;


public class Demo {
	private static void printOrder() {
		System.out.println("============================");
		System.out.println("��ӭʹ�þ�����Ϣ����ϵͳ");
		System.out.println("***��ѡ��˵�***");
		System.out.println("============================");
		System.out.println("1��������������ֲ�ͼ");
		System.out.println("2�������������ֲ�ͼ");
		System.out.println("3�����������·ͼ");
		System.out.println("4�����������·ͼ�еĻ�·");
		System.out.println("5�����������������·��");
		System.out.println("6�������·�޽��滮ͼ");
		System.out.println("7��ͣ��������������¼��Ϣ");
		System.out.println("8���˳�ϵͳ");
		System.out.println("��������Ҫѡ��Ĳ˵��");
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ScenicSpotGraph ssg = new ScenicSpotGraph();
		for(;;){
			printOrder();
			int i = s.nextInt();
			switch(i) {
				case 1: 
					ssg.CreateScenicSpotGraph();
					break;
				case 2: 
					if(ScenicSpotGraph.isGraphCreated == false){
						System.out.println("��������ֲ�ͼ��δ���������ȴ�����������ֲ�ͼ��");
						break;
					}else{
						ssg.outputScenicSpotGraph();
					}
				case 3: 
					break;
				case 4: 
					break;
				case 5: 
					break;
				case 6: 
					break;
				case 7: 
					break;
				case 8:
					System.exit(0);
				default: 
					System.out.println("�������");
					System.out.println("������1-8��������ѡ��");
					break;
			}
		}
	}

}
