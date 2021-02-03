package br.com.congresso.dbmock;

public class DBMock {

	public static boolean auth(String user, String pass){
		if(user.equals("Teste") && pass.equals("123")){
			return true;
		}
		return false;
	}
	
}
