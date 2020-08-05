package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import dao.BooksDAO;
import dbconnection.ConnectionFactory;
import dto.Books;
import dto.HistoryBook;
import dto.Student;

public class BookDAOImpl implements BooksDAO {

	@Override
	public ArrayList<Books> getAllBooks() {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		ArrayList<Books> araylistbook = new ArrayList<Books>();
		String sql = "SELECT * FROM books ";
		try {
			con = ConnectionFactory.getConnection();
			sta = con.createStatement();
			rs =sta.executeQuery(sql);
			while(rs.next()) {
				Books book = new Books();
				book.setBookID(rs.getInt("bookID"));
				book.setName(rs.getString("name"));
				book.setTotalPage(rs.getInt("totalPage"));
				book.setType(rs.getString("type"));
				book.setQuantity(rs.getInt("quantity"));
				araylistbook.add(book);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(sta!=null) {
				try {
					sta.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return araylistbook;
	}
	@Override
	public void insertBook(Books books) {
		Connection con = null;
		PreparedStatement pre = null;
		String sql = " INSERT INTO books(name,totalPage,type,quantity) VALUES (?,?,?,?) ";
		try {
			con = ConnectionFactory.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, books.getName());
			pre.setInt(2, books.getTotalPage());
			pre.setString(3,books.getType());
			pre.setInt(4, books.getQuantity());
			pre.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
			if(pre!=null) {
				try {
					pre.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public void updateBook(Books books) {
		Connection con = null;
		PreparedStatement pre = null;
		String sql = " UPDATE books SET name=? , totalPage=? , type=? , quantity=?  WHERE bookID=?  ";
		try {
			con = ConnectionFactory.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, books.getName());
			pre.setInt(2, books.getTotalPage());
			pre.setString(3,books.getType());
			pre.setInt(4, books.getQuantity());
			pre.setInt(5, books.getBookID());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(pre!=null) {
				try {
					pre.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public void deleteBook(int bookID) {
		Connection con = null;
		Statement sta = null;
		String sql = "DELETE FROM books WHERE bookID="+bookID;
		try {
			con = ConnectionFactory.getConnection();
			sta = con.createStatement();
			sta.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(sta!=null) {
				try {
					sta.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
//	@Override
//	public Books queryQuantityExists(int id) {
//		Connection con = null ;
//		Statement sta = null;
//		ResultSet rs = null;
//		Books bookquery = new Books();
//		String sql = "SELECT * FROM books WHERE bookID="+id;
//		try {
//			con = ConnectionFactory.getConnection();
//			sta = con.createStatement();
//			rs = sta.executeQuery(sql);
//			while(rs.next()) {
//				bookquery.setQuantityExists(rs.getInt("quantityExists"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null){
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if(sta!=null) {
//				try {
//					sta.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if(rs!=null) {
//				try {
//					rs.close();
//				}  catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return bookquery;
//	}
//	@Override
//	public void updateQuantityExists(int updateSLT , int id) {
//		Connection con = null;
//		PreparedStatement pre = null;
//		String sql ="UPDATE books SET quantityExists=? WHERE bookID=?";
//		try {
//			con = ConnectionFactory.getConnection();
//			pre=con.prepareStatement(sql);
//			pre.setInt(1, updateSLT);
//			pre.setInt(2, id);
//			pre.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if(pre!=null) {
//				try {
//					pre.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		
//	}
	@Override
	public void updateBorrows(int ids, int id, String date, int soLuongMuon) {
		Connection con = null;
		PreparedStatement pre = null;
		String sql = " INSERT INTO Borrows(StudentID,BookID,BorrowDate,Quantity) VALUES(?,?,?,?)";
		try {
			con = ConnectionFactory.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, ids);
			pre.setInt(2, id);
			pre.setString(3, date);
			pre.setInt(4, soLuongMuon);
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
			if(pre!=null) {
				try {
					pre.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public Books getBooksById(int id) {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM books WHERE bookID="+id;
		try {
			con = ConnectionFactory.getConnection();
			sta = con.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()) {
				Books book = new Books();
				book.setBookID(rs.getInt("bookID"));
				book.setName(rs.getString("name"));
				book.setTotalPage(rs.getInt("totalPage"));
				book.setType(rs.getString("type"));
				book.setQuantity(rs.getInt("quantity"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(sta!=null) {
				try {
					sta.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	@Override
	public int SCL(int id) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		int a = 0;
		String sql = "  SELECT (SUM(bo.quantity) - br.tong) AS tongsoconglai FROM books bo ,(SELECT BookID,SUM(br.quantity) tong FROM  borrows br WHERE  br.BookID = ?) br WHERE br.BookID = bo.BookID";
		try {
			con = ConnectionFactory.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				 a = rs.getInt("tongsoconglai");
				return a ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
			if(pre!=null) {
				try {
					pre.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	

}
