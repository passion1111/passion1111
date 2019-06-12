package ex06_io;

import java.io.Serializable;

public class Grade implements Serializable{//serializable입력된 순서를 기억해서 꺼내올떄도 입력된순서대로가져올수있다.
	private String subject;
	private int	score;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Grade [subject=" + subject + ", score=" + score + "]";
	}
	public void setScore(int score) {
		this.score = score;
	}
}
