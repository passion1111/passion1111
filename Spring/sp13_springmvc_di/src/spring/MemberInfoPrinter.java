package spring;

public class MemberInfoPrinter {

		private MemberDao memdao;
		private MemberPrinter printer;
		
		public MemberDao getMemdao() {
			return memdao;
		}
		public void setMemdao(MemberDao memdao) {
			this.memdao = memdao;
		}
		public MemberPrinter getPrinter() {
			return printer;
		}
		public void setPrinter(MemberPrinter printer) {
			this.printer = printer;
		}
		
		
		public void printMemberInfo(String email) {
		Member member=memdao.selectByEmail(email);
		if(member==null) {
			System.out.println("데이터 없음");
			return ;
		}
		printer.print(member);
		System.out.println();
}
}
