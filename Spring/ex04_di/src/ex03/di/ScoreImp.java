package ex03.di;

import ex02.di.Person;

public class ScoreImp implements Score {
		private int kor,eng,com;
		
		public ScoreImp() {
			this(0,0,0);
		}

		public ScoreImp(int kor, int eng, int com) {
			this.kor = kor;
			this.eng = eng;
			this.com = com;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getCom() {
			return com;
		}

		public void setCom(int com) {
			this.com = com;
		}

		@Override
	public int total() {
		return kor+eng+com;
	}


	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return total()/3.0f;
	}



}
