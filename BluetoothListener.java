	import java.io.*;

public class BluetoothListener {
	public static void main(String args[]){

		String s = null;
		int conn = 0;

		try {
			Process p = Runtime.getRuntime().exec("hcitool con");	
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while((s = stdInput.readLine()) != null){
				if(s.contains("00:15:83:00:43:EC")){
					System.out.println("Connection to headunit was successful!");
					conn++;
				}
			}
			if(conn == 0){
				System.out.println("Connection to headunit was not successful!");
			}

                        
		} 
		catch (IOException e) {
			System.out.println(e);
		}

		System.out.println(conn);
		
	}

}
