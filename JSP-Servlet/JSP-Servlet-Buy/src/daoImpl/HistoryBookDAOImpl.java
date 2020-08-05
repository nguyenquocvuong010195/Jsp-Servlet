package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.HistoryBooks;
import dbconnection.ConnectionFactory;
import dto.HistoryBook;

public class HistoryBookDAOImpl implements HistoryBooks {

	@Override
	public List<HistoryBook> danhSachMuonSach(int id) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<HistoryBook> listHBook = new ArrayList<HistoryBook>();
		String sql ="SELECT s.nameStudent,b.name,br.BorrowDate, br.quantity\r\n" + 
				"FROM students s, borrows br, books b\r\n" + 
				"where s.studentId = br.studentID \r\n" + 
				"AND b.bookID = br.bookID\r\n" + 
				"AND br.StudentID=?";
		try {
			con = ConnectionFactory.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				HistoryBook hb = new HistoryBook();
				hb.setBookName(rs.getString("name"));
				hb.setStudentName(rs.getString("nameStudent"));
				hb.setDateBorrows(rs.getDate("BorrowDate"));
				hb.setQuantity(rs.getInt("quantity"));
				listHBook.add(hb);
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
		
		return listHBook;
	}

	@Override
	public List<HistoryBook> getAllBookOnBorrow() {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		List<HistoryBook> listHBook = new ArrayList<HistoryBook>();
		String sql = "SELECT s.nameStudent,b.name,br.BorrowDate, br.quantity\r\n" + 
				"FROM students s, borrows br, books b\r\n" + 
				"where s.studentId = br.studentID \r\n" + 
				"AND b.bookID = br.bookID;";
		try {
			con = ConnectionFactory.getConnection();
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()) {
				HistoryBook hb = new HistoryBook();
				hb.setBookName(rs.getString("name"));
				hb.setStudentName(rs.getString("nameStudent"));
				hb.setDateBorrows(rs.getDate("BorrowDate"));
				hb.setQuantity(rs.getInt("quantity"));
				listHBook.add(hb);
				
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
		return listHBook;
	}

}
