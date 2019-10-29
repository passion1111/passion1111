package lib.employee.book.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lib.member.model.MemberDTO;

@Repository
public class EmpBookDaoImpl implements EmpBookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	
	@Override
	public void returnBook(RentalDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).returnBook(dto);
	}

	
	@Override
	public void addRentCnt(int book_num) {
		sqlsession.getMapper(EmpBookDAO.class).addRentCnt(book_num);
	}

	@Override
	public void rentBook(RentalDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).rentBook(dto);
	}

	@Override
	public List<EmpBookDTO> rentMemBookCheck(String mem_id) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).rentMemBookCheck(mem_id);
		return list;
	}

	@Override
	public List<MemberDTO> rentMemCheck(String mem_id) {
		List<MemberDTO> list = sqlsession.getMapper(EmpBookDAO.class).rentMemCheck(mem_id);
//		for (int i = 0; i < list.size(); i++) {
//	// 만약 		 reservation번호가 1이상 
//			//if(list.get(i).get)
//			
//			
//		}
		
		return list;
	}

	@Override
	public EmpBookDTO rentBookCheck(int book_num) {
		EmpBookDTO empBookDTO = sqlsession.getMapper(EmpBookDAO.class).rentBookCheck(book_num);
		return empBookDTO;
	}

	@Override
	public int selectRowNum() {
		return sqlsession.getMapper(EmpBookDAO.class).selectRowNum();
	}

	@Override
	public List<EmpBookDTO> select(int startRowNum, int endRowNum) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).select(startRowNum,endRowNum);
		return list;
	}

	@Override
	public List<EmpBookDTO> searchAll(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchAll("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<EmpBookDTO> searchCtgr(Map<String, String> parameters) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchCtgr(parameters);
		return list;
	}

	@Override
	public void insertBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).insertBook(dto);
	}
	
	@Override
	public void deleteBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).deleteBook(dto);
	}

	@Override
	public void updateBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).updateBook(dto);
	}
	
	@Override
	public int hopeSelectRowNum() {
		return sqlsession.getMapper(EmpBookDAO.class).hopeSelectRowNum();
	}
	
	@Override
	public void hopeApprove(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeApprove(dto);
	}
	
	@Override
	public void hopeReturn(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeReturn(dto);
	}
	
	@Override
	public void hopeDelete(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeDelete(dto);
	}
	
	@Override
	public List<Hope_BookDTO> hopeSelect(int startRowNum, int endRowNum) {
		List<Hope_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).hopeSelect(startRowNum, endRowNum);
		return list;
	}
	
	@Override
	public List<New_BookDTO> newSelect() {
		List<New_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).newSelect();
		return list;
	}

	@Override
	public List<New_BookDTO> newSelectBook() {
		List<New_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).newSelectBook();
		return list;
	}
	
	@Override
	public void newInsertBook(New_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).newInsertBook(dto);
	}
	@Override
	public int newMaxBookNum() {
		return sqlsession.getMapper(EmpBookDAO.class).newMaxBookNum();
	}
	
	@Override
	public void newDeleteBook(New_BookDTO dto) {
		System.out.println("Controller) dto.getNew_book_num_sub() >> " + dto.getNew_book_num_sub());
		sqlsession.getMapper(EmpBookDAO.class).newDeleteBook(dto);
	}
	
	@Override
	public void newUpdateBook(New_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).newUpdateBook(dto);
	}

	@Override
	public BookRentDisDTO disSearch(int book_num) {
		BookRentDisDTO bookRentDisDTO = sqlsession.getMapper(EmpBookDAO.class).disSearch(book_num);
		return bookRentDisDTO;
	}
	
	@Override
	public List<BookRentDisDTO> disSelect() {
		List<BookRentDisDTO> list = sqlsession.getMapper(EmpBookDAO.class).disSelect();
		return list;
	}
	
	@Override
	public List<BookRentDisDTO> disSelectBook() {
		List<BookRentDisDTO> list = sqlsession.getMapper(EmpBookDAO.class).disSelectBook();
		return list;
	}
	
	@Override
	public void disInsertBook(BookRentDisDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).disInsertBook(dto);
	}
	
	@Override
	public void disDeleteBook(BookRentDisDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).disDeleteBook(dto);
	}


	@Override
	public void rentalbook(int book_num) {
		// TODO Auto-generated method stub
		
	}
}
