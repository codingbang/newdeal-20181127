package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    //출력 - 번호,내용,작성일,조회수
    
    final int DEFAULT_SIZE = 20;
    
    int[] no = new int[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] writeDate = new Date[DEFAULT_SIZE];
    int[] viewCount = new int[DEFAULT_SIZE];
    
    Scanner keyIn = new Scanner(System.in);
    
    int len = 0;
    
    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());
      
      System.out.print("내용? ");
      contents[i] = keyIn.nextLine();
      
      viewCount[i] = 0;
      writeDate[i] = new Date(System.currentTimeMillis());
      
      len++;
      
      System.out.println("계속 입력 하시겠습니까?(Y/n) ");
      String quitInput = keyIn.nextLine();
      
      if (quitInput.equals("") || quitInput.equalsIgnoreCase("y")) {
        
        continue;
      }
      break;
    }
    
    System.out.println();
  //출력 - 번호,이름,이메일,전화,가입일
    for (int i = 0; i < len; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("내용: %s\n", contents[i]);
      System.out.printf("작성일: %s\n", writeDate[i]);
      System.out.printf("조회수: %d\n\n", viewCount[i]);

    }
  }

}
