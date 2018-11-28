package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    //입력 - 번호,이름,이메일,암호,사진,전화,가입일
    //출력 - 번호,이름,이메일,전화,가입일
    
    final int DEFAULT_SIZE = 20;
    
    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] pwd = new String[DEFAULT_SIZE];
    String[] photo = new String[DEFAULT_SIZE];
    String[] tel = new String[DEFAULT_SIZE];
    Date[] joinDate = new Date[DEFAULT_SIZE];
    
    Scanner keyIn = new Scanner(System.in);
    
    int len = 0;
    
    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());
      
      System.out.print("이름? ");
      name[i] = keyIn.nextLine();
      
      System.out.print("이메일? ");
      email[i] = keyIn.nextLine();
      
      System.out.print("암호? ");
      pwd[i] = keyIn.nextLine();
      
      System.out.print("사진? ");
      photo[i] = keyIn.nextLine();
      
      System.out.print("전화? ");
      tel[i] = keyIn.nextLine();
      
      joinDate[i] = new Date(System.currentTimeMillis());
      
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
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("이메일: %s\n", email[i]);
      System.out.printf("전화: %s\n", tel[i]);
      System.out.printf("가입일: %s\n\n", joinDate[i]);
    }
  }

}
