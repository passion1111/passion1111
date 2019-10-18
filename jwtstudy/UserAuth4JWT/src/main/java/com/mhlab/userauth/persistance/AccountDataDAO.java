package com.mhlab.userauth.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mhlab.userauth.domain.AccountDataVO;

public interface AccountDataDAO {
	public void ta_insert(AccountDataVO accountDataVO) throws Exception;
	public List<AccountDataVO> ta_getByListForAll() throws Exception;
	public AccountDataVO ta_getByOneForIdAndPw(@Param("ta_id")String ta_id,@Param("ta_pw") String ta_pw) throws Exception;
	public AccountDataVO ta_getByOneForId(String ta_id) throws Exception;
	public AccountDataVO ta_getByOneForPw(String ta_pw) throws Exception;
	public void ta_updateForIdx(AccountDataVO accountDataVO) throws Exception;
	public void ta_deleteForIndex(int ta_idx) throws Exception;
}
