package exam02_select;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class selectExample09_1 {
   
   public static void main(String[] args) throws Exception{
      
      ConnectionManager.init();   
      Thread[] threads=new Thread[200];
      for(int i=0;i<200;i++) {
         threads[i]=new Thread() {
            @Override
            public void run() {
               printSalary();
            }
         };
         
      }
      long start=System.nanoTime();
      for(int i=0;i<200;i++) {
         threads[i].join();
      }
      for(int i=0;i<200;i++) {
         threads[i].start();
      }   
      
      long end=System.nanoTime();
      long time=end-start;
      System.out.println(time+"ns");
   }
   
   public static void printSalary() {
      Connection conn=null;
      Scanner scanner=new Scanner(System.in);
      
      try {
         //연결
         Class.forName("oracle.jdbc.OracleDriver");
         conn=ConnectionManager.getConnection2();
         //sql작성
         
         String sq2="select employee_id,first_name,last_name,hire_date from employees where employee_id=?";
         
         //sql실행 state얻기
         PreparedStatement pstm=conn.prepareStatement(sq2);
         pstm.setInt(1, 100);
      
         //실행해서 결과셋얻기
         ResultSet rs=pstm.executeQuery();
         
         //행값 읽기
         if(rs.next()) {
            int empid=rs.getInt("employee_id");
            String f=rs.getString("first_name");
            String l=rs.getString("last_name");
            Date hiredDate=rs.getDate("hire_date");
            Thread thread=Thread.currentThread();
            System.out.println(thread.getName()+empid+","+f+","+l+","+hiredDate);
         }
         //메모리해제
         rs.close();
         pstm.close();
         //연결해제
         
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            conn.close();
         }catch(SQLException e) {
            
         }
      }
      
   }

}