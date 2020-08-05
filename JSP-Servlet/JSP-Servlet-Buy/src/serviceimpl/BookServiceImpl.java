package serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import daoImpl.BookDAOImpl;
import dto.Books;
import service.BookService;

public class BookServiceImpl implements BookService {

	final BookDAOImpl bookDao = new BookDAOImpl() ;
	@Override
	public List<Books> getAllBooks() {
		List<Books> listBook = bookDao.getAllBooks();
		return listBook;
	}

	@Override
	public Books getBooksById(int id) {
		Books book = bookDao.getBooksById(id);
		return book;
	}

	@Override
	public boolean updateBorrows(int idMuon, int id, int soLuongMuon) {
		//Books books = bookDao.getBooksById(id);
//		int quantity = books.getQuantity();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatterFull = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String localDate = localDateTime.format(formatterFull);
		int soLuongConLai = bookDao.SCL(id);
		if(soLuongConLai-soLuongMuon > 0) {
			bookDao.updateBorrows(idMuon, id, localDate, soLuongMuon);
			return true;
		}
		return false;
	}
	
}
