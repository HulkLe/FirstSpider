import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

	private static Manager manager=new Manager();
	public static Manager getManager() 
	{
		return manager;
	}
	
	public String catchText(String urlString) throws IOException 
	{ //通过url捕获所有内容
		
		String res="";
		URL url=new URL(urlString);
		
		URLConnection con=url.openConnection();
		con.connect();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line;
		while((line=reader.readLine())!=null)
		{
			res+=line+"\n";
		}
		
		System.out.println(res);
		
		return res;
	}
	
	
	
	public String RegexString(String targetStr, String patternStr)
	{
		
		Pattern pattern = Pattern.compile(patternStr);
	
		Matcher matcher = pattern.matcher(targetStr);
	
		if (matcher.find())
		{
			return matcher.group(1);
		}
		return "";
	}

    public void download(String urlString) throws Exception {  
        
        URL url = new URL(urlString);  
        
        URLConnection con = url.openConnection();  
     
        con.setConnectTimeout(5*1000);  
      
        InputStream is = con.getInputStream();  
        
        byte[] bs = new byte[10240];  
       
        int len;  
        
        FileOutputStream os = new FileOutputStream("F:\\图片\\a.jpg");  
       
        while ((len = is.read(bs)) != -1) {  
          os.write(bs, 0, len);  
        }  
       
        os.close();  
        is.close();  
    }   
}
