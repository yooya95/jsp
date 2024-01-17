package och06;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fibonazzi
 */
@WebServlet("/Fibonazzi")
public class Fibonazzi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BigInteger[] arr = new BigInteger[100];
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fibonazzi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Fibonazzi init...");
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("1");
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1]);
			
		}
		//            Index Value  add  Index Value
		//  2          0     1      +    1      1
		//  3          1     1      +    2      2
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Fibonazzi doGet...");
		int num = Integer.parseInt(request.getParameter("num"));
		if (num > 100)			num = 100;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>피보나찌수열</h2>");
		for (int i = 0; i < num; i++) {
			out.println(arr[i] + "<br>");
		}
		out.println("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
