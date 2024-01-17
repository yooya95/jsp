package och14;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class uploadBoard3
 */
@WebServlet("/uploadBoard3")
public class uploadBoard3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadBoard3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UploadBoard3 dopost start...");
		String serverSaveFilename="";
		String upLoadFilename ="";
		request.setCharacterEncoding("utf-8");
		int maxSize = 5 * 1024 * 1024;
		String fileSave = "/fileSave";
		String realPath = getServletContext().getRealPath(fileSave);
		System.out.println("realPath->" +realPath);
		//UpLoad
		MultipartRequest multi =
				new MultipartRequest(request, realPath, maxSize,"utf-8",new DefaultFileRenamePolicy());
		//UpLoad된 file 정보 확인
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) {
			
			String parameterName = (String)en.nextElement();
			serverSaveFilename = multi.getFilesystemName(parameterName);
			String original = multi.getOriginalFileName(parameterName);
			String type = multi.getContentType(parameterName);
			
			File file = multi.getFile(parameterName);
			System.out.println("realPath->"+realPath);
			System.out.println("파라메터이름->"+parameterName);
			System.out.println("실제파일이름->"+original);
			System.out.println("저장된파일이름->"+serverSaveFilename);
			System.out.println("파일타입->"+type);
			if(file!=null) {
				
				System.out.println("크기->" + file.length());
				//out.println("크기 : " + file.length()+"<Br>);
			}
			String name =  multi.getParameter("name");
			String title = multi.getParameter("title");
			System.out.println("name->"+name);
			System.out.println("title->"+title);
			
			upLoadFilename = realPath + "\\" + serverSaveFilename;
			System.out.println("전달 upLoadFilename ->"+upLoadFilename );
			
			request.setAttribute("filename", "filesave//"+serverSaveFilename);
			request.setAttribute("upLoadFilename", upLoadFilename);
			request.setAttribute("realPath", realPath);
			request.setAttribute("title", title);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("uploadBoardResult.jsp");
			rd.forward(request, response);
			
			
			
			
			
		}
		
	}

}
