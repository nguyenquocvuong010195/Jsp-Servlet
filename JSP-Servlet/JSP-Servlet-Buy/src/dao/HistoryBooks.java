package dao;

import java.util.ArrayList;
import java.util.List;

import dto.HistoryBook;

public interface HistoryBooks {
	public List<HistoryBook> danhSachMuonSach(int id);
	public List<HistoryBook> getAllBookOnBorrow();

}
