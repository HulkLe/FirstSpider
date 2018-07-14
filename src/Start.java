public class Start
{
		public static void main(String[] args) throws Exception
		{
			String url = "http://www.baidu.com";  
		
			String result = Manager.getManager().catchText(url);   //从对应网站获得html的文本类容
			
			System.out.println(result);
			
			String imgSrc = Manager.getManager().RegexString(result, "src=//(.+?) "); //用正则表达式匹配图片网址
		
			System.out.println(imgSrc);

	        Manager.getManager().download("http://"+imgSrc);//下载图片到对应位置

			
		}
}
