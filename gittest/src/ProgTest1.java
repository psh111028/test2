

public class ProgTest1 {
	public static int cVar = 0;
	String[] iStr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	double iDouble;
	boolean iBool = false;
	char iChar = 'a';
	
	public String getGugudan(int dan) {
		String result= dan + "´Ü:\n";
		for (int i = 0; i < 9; i++) {
			result = result + dan + "*" + (i + 1) + "=" + dan * (i + 1) + "\t"; 
		}
		return result;
	}
}