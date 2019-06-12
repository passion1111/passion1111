package quiz.video.two;

import java.util.Date;

public class Video {
	 protected String 
		title, //비디오제목
		category, //장르
		lend, //대여여부
		lendName, // 대여자(고객명)
		lendDate;  // 대여일자(오늘날짜 입력하심 되요)

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
