package codingdojang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//10�̸��� �ڿ������� 3�� 5�� ����� ���ϸ� 3,5,6,9�̴�. �̵��� ������ 23�̴�.
//
//1000�̸��� �ڿ������� 3,5�� ����� ������ ���϶�.
public class Personal_codingdojang2 {
	 public static void main(String[] args)
	    {
	        try{
	            //���Ϸκ��� �Է¹���
	            File input_file = new File("input.txt");
	            FileReader fileReader = new FileReader(input_file);
	            BufferedReader reader = new BufferedReader(fileReader);     
	            //��� ��� ���� ����
	            FileWriter fileWriter = new FileWriter("output.txt");
	            BufferedWriter writer = new BufferedWriter(fileWriter);

	            int input_ascii;

	            while( ( input_ascii = reader.read() ) != -1 ){
	                //�����ϳ��ϳ��� �ƽ�Ű�� �޾ƿͼ� char������ ��ȯ�Ͽ� ���
	                char input_char = (char)input_ascii;

	                if( input_char == 9 ){
	                    //tab�� �ƽ�Ű�ڵ�� 9, ������ �ƽ�Ű�ڵ�� 32
	                    input_char = 32;
	                    //�Ǹ����� ���� 4��
	                    for( int i=1; i<=4; i++){
	                        writer.write( input_char );
	                        //System.out.print(input_char);
	                    }
	                }
	                else{   //�� �ƴ� �ٸ� ���ڵ��� �׳� �״�� ���
	                    writer.write( input_char );
	                    //System.out.print(input_char);
	                }

	            }
	            writer.close(); //�ȴݾ��ָ� �ȵ�
	            reader.close();

	        }
	        catch(Exception ex){

	        }
	    }
	}