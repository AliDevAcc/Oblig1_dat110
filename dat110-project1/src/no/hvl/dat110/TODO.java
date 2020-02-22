package no.hvl.dat110;

public class TODO {

	public static String method() {
		
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		return "Metoden " + methodName + " er ikke implementert";
	}
	
	
	public static String construtor(String className) {
				
	   return "Konstruktøren for klassen " + className + " er ikke implementert";
		
	}
public static void main(String[] args) {
//	byte [] b= new byte[2];
//	b[0]="a";
//	b[1]="a";
//	b[2]="a";
//	String s="";
//	for(int i=0; i< 4; i++) {
//	s+=s
	}
}

