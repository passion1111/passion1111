package spring;

import java.util.Collection;

public class MemberListPrinter {

	private MemberDao memdao;
	private MemberPrinter printer;
	public MemberListPrinter(MemberDao memdao, MemberPrinter printer) {
		super();
		this.memdao = memdao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members=memdao.selectAll();
		for(Member m:members) {
			printer.print(m);
		}
	}
}
