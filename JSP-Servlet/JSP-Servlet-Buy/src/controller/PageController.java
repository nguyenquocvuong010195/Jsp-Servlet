package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.BookDAOImpl;
import daoImpl.HistoryBookDAOImpl;
import daoImpl.StudentsDAOImpl;
import dto.Books;
import dto.CheckUser;
import dto.HistoryBook;
import dto.Student;
import serviceimpl.BookServiceImpl;

/**
 * Servlet implementation class PageController
 */
@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		try {
			switch (action) {
			case "login":
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				break;
			case "loginTT":
				request.setCharacterEncoding("UTF-8"); 
				HttpSession session = request.getSession();
				String userName = request.getParameter("user");
				String passWord = request.getParameter("pass");
				StudentsDAOImpl stud = new StudentsDAOImpl();
				Student stud1 = stud.findStudentByUserAndPassword(userName, passWord);
				if(stud1 != null){
					int idS = stud1.getStudentID();
					session.setAttribute("idS", idS);
					String username = stud1.getName();
					session.setAttribute("username",username);
					session.setAttribute("role", stud1.getRole());
					response.sendRedirect(request.getContextPath() + "/PageController?action=homepage");
				} else {
					request.setAttribute("errormessage", "Login failed");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				break;
			case "logout":
				HttpSession session1=request.getSession();
				session1.invalidate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				break;

			case "homepage":
				request.setCharacterEncoding("UTF-8"); 
				String username = (String) request.getSession().getAttribute("username");
				request.setAttribute("username", username);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/homepage.jsp");       
				dispatcher.forward(request, response);
				break;
			case "borrowsbooks":
				List<Books> listBook = bookServiceImpl.getAllBooks();
				request.setAttribute("listBook", listBook);
				RequestDispatcher rd2 = request.getRequestDispatcher("books.jsp");
				rd2.forward(request, response);
				break;
			case "borrowsbooksManager":
				HttpSession session2 = request.getSession();
				int soLuongMuon = Integer.parseInt(request.getParameter("soLuong"));
				int id = Integer.parseInt(request.getParameter("bookId"));
				int idMuon =  (int) session2.getAttribute("idS");
				System.out.println("im here");
				if(bookServiceImpl.updateBorrows(idMuon, id, soLuongMuon)) {
					System.out.println("im here");
					request.setAttribute("errormessage", "mượn sách thành công");

					RequestDispatcher rd1 = request.getRequestDispatcher("/BookController?action=borrowsbooks");
					rd1.forward(request, response);
				}else {
					System.out.println("teo");
					request.setAttribute("errormessage", "sách đã hết , mời nhập lại");
					RequestDispatcher rd1 = request.getRequestDispatcher("/BookController?action=borrowsbooks");
					rd1.forward(request, response);
				}
				break;
			case "booksHistoryMS":
				HttpSession session3 = request.getSession();
				int id5 = (int) session3.getAttribute("idS");
				HistoryBookDAOImpl hisI = new HistoryBookDAOImpl();
				List<HistoryBook> hisb = hisI.danhSachMuonSach(id5);
				request.setAttribute("hisb", hisb);
				RequestDispatcher rd3 = request.getRequestDispatcher("/historyBook.jsp");
				rd3.forward(request, response);
				break;
			case "createStudent":
				RequestDispatcher rd6 = request.getRequestDispatcher("createStudent.jsp");
				rd6.forward(request, response);
				break;
			case "createStudentTT":
				this.CreateStudentTT(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void CreateStudentTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		request.setCharacterEncoding("UTF-8"); 
		String fName = request.getParameter("fullname");
		String uName = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		int gDer = Integer.parseInt(request.getParameter("gender"));
		String rolle = request.getParameter("role");
		String pas = request.getParameter("password");
		StudentsDAOImpl stu = new StudentsDAOImpl();
		
		CheckUser check = stu.checkUser(uName);
		int checkUSER = check.getNumber();
		if(checkUSER==0) {
			Student stu4 = new Student();
			stu4.setName(fName);
			stu4.setUsername(uName);
			stu4.setAge(age);
			stu4.setGender(gDer);
			stu4.setPassword(pas);
			StudentsDAOImpl stud = new StudentsDAOImpl();
			stud.createStudent(stu4);
			request.setAttribute("username", uName);
			response.sendRedirect(request.getContextPath() + "/PageController?action=homepage");
		}else {
			request.setAttribute("errormessage", "User Name đã tồn tại vui lòng thử tên khác");
			RequestDispatcher rd = request.getRequestDispatcher("createStudent.jsp");
			rd.forward(request, response);
		}
	
	}
}
