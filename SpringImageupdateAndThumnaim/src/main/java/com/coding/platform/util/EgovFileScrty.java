/*package com.nptech.platform.util;

public class EgovFileScrty {

}
*/

/**
 *  Class Name : EgovFileScrty.java
 *  Description : Base64인코딩/디코딩 방식을 이용한 데이터를 암호화/복호화하는 Business Interface class
 *  Modification Information
 *
 *     수정일         수정자                   수정내용
 *   -------    --------    ---------------------------
 *   2009.02.04    박지욱          최초 생성
 *
 *  @author 공통 서비스 개발팀 박지욱
 *  @since 2009. 02. 04
 *  @version 1.0
 *  @see
 *
 *  Copyright (C) 2009 by MOPAS  All right reserved.
 */
package com.coding.platform.util;
import java.io.File;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;
public class EgovFileScrty {
    // 파일구분자
    static final char FILE_SEPARATOR = File.separatorChar;
    static final int BUFFER_SIZE = 1024;
    /**
     * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
     * 
     * @param password 암호화될 패스워드
     * @param id salt로 사용될 사용자 ID 지정
     * @return
     * @throws Exception
     */
    public static String encryptPassword(String password, String id) throws Exception {
  if (password == null) {
      return "";
  }
 
  byte[] hashValue = null; // 해쉬값
 
  MessageDigest md = MessageDigest.getInstance("SHA-256");
  
  md.reset();
  md.update(id.getBytes());
  
  hashValue = md.digest(password.getBytes());
 
  return new String(Base64.encodeBase64(hashValue));
    }
}
 