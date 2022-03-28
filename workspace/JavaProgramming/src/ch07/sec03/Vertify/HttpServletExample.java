package ch07.sec03.Vertify;

public class HttpServletExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method(new LoginServlet());
		method(new FileDownloadServelt());

	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
