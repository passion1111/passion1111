package lib.employee.board.model;

import lombok.Data;

@Data
public class BoardAttachDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	
	private Long board_no;

}
