package ex01.file;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) throws Exception{
		int i=0;
		String file;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("읽어 올 파일명을 입력하세요 . ->");
		file=br.readLine();
		
		System.out.println(file+"문서의 내용은...");
		FileReader fr=new FileReader(file);
		BufferedReader reader=new BufferedReader(fr);
		
		while((i=reader.read())!=-1) {
			System.out.println((char)i+"");
			if(fr.equals("\n"))System.out.print("\t");
		}
		fr.close();
		}
	}
	

