
import java.util.*;

	


class hw {

	String title;
	int deadline, score;
	public hw() {}

	public hw(String id, int deadline, int score)
	{
		this.title = id;
		this.deadline = deadline;
		this.score = score;
	}
	void homeworkPriority(ArrayList<hw> arr, int n)
	{
		Collections.sort(arr, (a, b) -> b.score - a.score);
		boolean flag = false;
		boolean dayIsFull[] = new boolean[n];
		String homework[] = new String[n];
		for (int i = 0; i < arr.size(); i++) {
			for (int j = Math.min(n - 1, arr.get(i).deadline - 1);j >= 0; j--) {
				if (dayIsFull[j] == false) {
					dayIsFull[j] = true;
					homework[j] = arr.get(i).title;
					break;
				}
			}
		}
		for (String hw : homework)
			if (hw != null) {
				if(flag) {
				System.out.print(" , ");}
			System.out.print(hw);
			flag = true;
		
			}
	}

	public static void main(String args[])
	{
		ArrayList<hw> arr = new ArrayList<hw>();
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] arrStr= new String[n];
		for (int i = 0; i < n; i++) {
			String str = scan.nextLine();
			arrStr = str.split(" ");
			arr.add(new hw(arrStr[0], Integer.parseInt(arrStr[1]), Integer.parseInt(arrStr[2])));
		}
		
		hw HW = new hw();
		HW.homeworkPriority(arr, n);
	}
}
