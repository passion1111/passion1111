package jwt.test.test;

import java.time.Instant;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;



public class TestHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestHomeController.class);
	
	@Test
	public void TestJson()  {
		
		
		String jws = Jwts.builder()
				  .setIssuer("Stormpath")
				  .setSubject("msilverman")
				  .claim("name", "Micah Silverman")
				  .claim("scope", "admins")
				  // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
				  .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
				  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
				  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				  .signWith(
				    SignatureAlgorithm.HS256,
				    TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
				  )
				  .compact();
			System.out.println(jws);

}
}