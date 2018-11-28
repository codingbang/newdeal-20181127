package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    
    System.out.print("번호? ");
    int no = Integer.parseInt(keyIn.nextLine());
    
    System.out.print("내용? ");
    String contents = keyIn.nextLine();
    
    Date currntDate = new Date(System.currentTimeMillis());
    int viewCount = 0;
    
    System.out.printf("\n번호: %d\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: %s\n", currntDate);
    System.out.printf("조회수: %d", viewCount);

  }

}
