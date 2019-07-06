package personal;
//반 배정 랜덤 프로그램. 
import java.util.Random;
 
public class  Personal_array_random{
    
    public static void main(String[] args) {
        
    String[] name= {"김승수","강수아","김광범","김세종","남민지","문혜수","박진산","손지형","박예원","이태성","배재준","정준모","조규민","옥영학","현상주","김현태","황인호","안희수","이소영"};
    String[] name3=new String[name.length];
    int[] name2= new int[name.length];
        Random random=new Random();
        int i=0,i2=0;
        i=random.nextInt(name.length);
        for(int i1=0;i1<name.length;i1++) //중복없이 배열name2에 랜덤숫자 넣는 프로그램
        {
            name2[i1]=random.nextInt(name.length);            
            for( i2=0;i2<i1;i2++) {
                if(name2[i2]==name2[i1]) {
                    i1=i1-1;
                }            
            }      
        }
 //
                for(int i1=0;i1<name.length;i1++) {
                                    name3[i1]=name[(name2[i1])];                                 
                                    if((i1%5)==0&&(i1!=0)) System.out.println("");
                                    System.out.print(name3[i1]+"\t");            
                }                
                }
    
        }
        
    
 