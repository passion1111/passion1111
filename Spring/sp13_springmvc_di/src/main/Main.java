package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;

public class Main {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException { //예외처리 위임
		
		String[] conf = { "classpath:configImport.xml" };
		ctx = new GenericXmlApplicationContext(conf);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력하세요. : ");
			String command = reader.readLine(); //예외발생
			
			if( command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			
			if( command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if( command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if( command.startsWith("list ")) {
				processListCommand(command.split(" "));
				continue;
			}else if( command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			}else if( command.startsWith("version")) {
				processVersionCommand(command.split(" "));
				continue;
			}
			printHelp();
		}// end while
	}

	public static void processVersionCommand(String[] arg) {
		VersionPrinter versionPrinter = 
				ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
		
	}

	public static void processInfoCommand(String[] arg) {
		if( arg.length != 2 ) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
		
	}

	public static void processListCommand(String[] arg) {
		MemberListPrinter listPrinter =
				ctx.getBean("listPrinter", MemberListPrinter.class);
		
	}

	private static void processChangeCommand(String[] arg) {
		if( arg.length != 4 ) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일 입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
		
	}

	public static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법 : ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경버전");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("version");
		System.out.println();		
	}

	public static void processNewCommand(String[] arg) {
		if( arg.length != 5 ) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		RegisterRequest reg = new RegisterRequest();
		reg.setEmail(arg[1]);
		reg.setName(arg[2]);
		reg.setPassword(arg[3]);
		reg.setConfirmPassword(arg[4]);
		
		if(!reg.isPasswordEqualsToConfirmPassword()) {
			System.out.println("암호와 암호확인이 일치하지 않습니다.\n");
			return;
		}
		
		try {
			regSvc.register(reg);
			System.out.println("등록했습니다.\n");
		} catch (AlreadyExistMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.\n");
		}
		
	}
	
	
}








