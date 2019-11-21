package lib.employee.book.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lib.member.model.MemberDTO;

@Repository
public class EmpBookDaoImpl implements EmpBookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	
	@Override
	@Transactional
	public void returnBook(RentalDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).returnBook(dto);
	}

	
	@Override
	@Transactional
	public void addRentCnt(int book_num) {
		sqlsession.getMapper(EmpBookDAO.class).addRentCnt(book_num);
	}

	@Override
	@Transactional
	public void rentBook(RentalDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).rentBook(dto);
	}

	@Override
	@Transactional
	public List<EmpBookDTO> rentMemBookCheck(String mem_id) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).rentMemBookCheck(mem_id);
		return list;
	}

	@Override
	@Transactional
	public List<MemberDTO> rentMemCheck(String mem_id) {
		List<MemberDTO> list = sqlsession.getMapper(EmpBookDAO.class).rentMemCheck(mem_id);

		
		return list;
	}

	@Override
	@Transactional
	public EmpBookDTO rentBookCheck(int book_num) {
		EmpBookDTO empBookDTO = sqlsession.getMapper(EmpBookDAO.class).rentBookCheck(book_num);
		return empBookDTO;
	}

	@Override
	@Transactional
	public int selectRowNum() {
		return sqlsession.getMapper(EmpBookDAO.class).selectRowNum();
	}

	@Override
	@Transactional
	public List<EmpBookDTO> select(int startRowNum, int endRowNum) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).select(startRowNum,endRowNum);
		return list;
	}

	@Override
	@Transactional
	public List<EmpBookDTO> searchAll(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchAll("%" + searchWord + "%");
		return list;
	}

	@Override
	@Transactional
	public List<EmpBookDTO> searchCtgr(Map<String, String> parameters) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchCtgr(parameters);
		return list;
	}

	@Override
	@Transactional
	public void insertBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).insertBook(dto);
	}
	
	@Override
	@Transactional
	public void deleteBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).deleteBook(dto);
	}

	@Override
	@Transactional
	public void updateBook(EmpBookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).updateBook(dto);
	}
	
	@Override
	@Transactional
	public int hopeSelectRowNum() {
		return sqlsession.getMapper(EmpBookDAO.class).hopeSelectRowNum();
	}
	
	@Override
	@Transactional
	public void hopeApprove(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeApprove(dto);
	}
	
	@Override
	@Transactional
	public void hopeReturn(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeReturn(dto);
	}
	
	@Override
	@Transactional
	public void hopeDelete(Hope_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).hopeDelete(dto);
	}
	
	@Override
	@Transactional
	public List<Hope_BookDTO> hopeSelect(int startRowNum, int endRowNum) {
		List<Hope_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).hopeSelect(startRowNum, endRowNum);
		return list;
	}
	
	@Override
	@Transactional
	public List<New_BookDTO> newSelect() {
		List<New_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).newSelect();
		return list;
	}

	@Override
	@Transactional
	public List<New_BookDTO> newSelectBook() {
		List<New_BookDTO> list = sqlsession.getMapper(EmpBookDAO.class).newSelectBook();
		return list;
	}
	
	@Override
	@Transactional
	public void newInsertBook(New_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).newInsertBook(dto);
	}
	@Override
	@Transactional
	public int newMaxBookNum() {
		return sqlsession.getMapper(EmpBookDAO.class).newMaxBookNum();
	}
	
	@Override
	@Transactional
	public void newDeleteBook(New_BookDTO dto) {
		System.out.println("Controller) dto.getNew_book_num_sub() >> " + dto.getNew_book_num_sub());
		sqlsession.getMapper(EmpBookDAO.class).newDeleteBook(dto);
	}
	
	@Override
	@Transactional
	public void newUpdateBook(New_BookDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).newUpdateBook(dto);
	}

	@Override
	@Transactional
	public BookRentDisDTO disSearch(int book_num) {
		BookRentDisDTO bookRentDisDTO = sqlsession.getMapper(EmpBookDAO.class).disSearch(book_num);
		return bookRentDisDTO;
	}
	
	@Override
	@Transactional
	public List<BookRentDisDTO> disSelect() {
		List<BookRentDisDTO> list = sqlsession.getMapper(EmpBookDAO.class).disSelect();
		return list;
	}
	
	@Override
	@Transactional
	public List<BookRentDisDTO> disSelectBook() {
		List<BookRentDisDTO> list = sqlsession.getMapper(EmpBookDAO.class).disSelectBook();
		return list;
	}
	
	@Override
	@Transactional
	public void disInsertBook(BookRentDisDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).disInsertBook(dto);
	}
	
	@Override
	@Transactional
	public void disDeleteBook(BookRentDisDTO dto) {
		sqlsession.getMapper(EmpBookDAO.class).disDeleteBook(dto);
	}




	

	@Override
	@Transactional
	public int rentBookExtension(int book_num) {
		return sqlsession.getMapper(EmpBookDAO.class).rentBookExtension(book_num);
		
	}


	@Override
	@Transactional
	public int rentBookReservation(EmpBookDTO dto) {
		
		return sqlsession.getMapper(EmpBookDAO.class).rentBookReservation(dto);
	}


	@Override
	@Transactional
	public int rentBookReservationcount(EmpBookDTO dto) {
		return sqlsession.getMapper(EmpBookDAO.class).rentBookReservationcount(dto);
	}


	@Override
	@Transactional
	public int rentBookReservationCheckAlreadyreservation(EmpBookDTO dto) {
		return sqlsession.getMapper(EmpBookDAO.class).rentBookReservationCheckAlreadyreservation(dto);
	}


}
