import java.io.IOException;

public class Utils {
	
	public static String loadFileAsString(String path){
		
		StringBuilder builder = new StringBuilder();
		
		try{
			BuffredReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
