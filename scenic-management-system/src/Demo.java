import java.util.*;


public class Demo {
	private static void printOrder() {
		System.out.println("============================");
		System.out.println("欢迎使用景区信息管理系统");
		System.out.println("***请选择菜单***");
		System.out.println("============================");
		System.out.println("1、创建景区景点分布图");
		System.out.println("2、输出景区景点分布图");
		System.out.println("3、输出导游线路图");
		System.out.println("4、输出导游线路图中的回路");
		System.out.println("5、求两个景点间的最短路径");
		System.out.println("6、输出道路修建规划图");
		System.out.println("7、停车场车辆进出记录信息");
		System.out.println("8、退出系统");
		System.out.println("请输入您要选择的菜单项：");
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
						System.out.println("景区景点分布图还未创建，请先创建景区景点分布图！");
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
					System.out.println("输入错误");
					System.out.println("请输入1-8进行重新选择");
					break;
			}
		}
	}

}
