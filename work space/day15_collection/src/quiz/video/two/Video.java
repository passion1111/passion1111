package quiz.video.two;

import java.util.Date;

public class Video {
	
	 protected String 
		title, //��������
		category, //�帣
		lend, //�뿩����
		lendName, // �뿩��(����)
		lendDate;  // �뿩����(���ó�¥ �Է��Ͻ� �ǿ�)

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLend() {
		return lend;
	}

	public void setLend(String lend) {
		this.lend = lend;
	}

	public String getLendName() {
		return lendName;
	}

	public void setLendName(String lendName) {
		this.lendName = lendName;
	}

	public String getLendDate() {
		return lendDate;
	}

	public void setLendDate(String date) {
		this.lendDate = date;
	}
	 
	 
}
