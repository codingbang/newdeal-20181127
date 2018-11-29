import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Member[] members = new Member[LENGTH];
    
    int i = 0;
    while (i < LENGTH) {
      members[i] = new Member();
      
      System.out.print("번호? ");
      members[i].no = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("이름? ");
      members[i].name = keyboard.nextLine();
      
      System.out.print("이메일? ");
      members[i].email = keyboard.nextLine();
      
      System.out.print("암호? ");
      members[i].password = keyboard.nextLine();
  
      System.out.print("사진? ");
      members[i].photo = keyboard.nextLine();
  
      System.out.print("전화? ");
      members[i].tel = keyboard.nextLine();
  
      members[i].registeredDate = new Date(System.currentTimeMillis()); 
      
      i++;
      
      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();
      
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }
    
    keyboard.close();
    
    System.out.println();
    
    // 배열에 입력한 개수만큼 출력한다.
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, members[j].email, members[j].tel, members[j].registeredDate);
    }
  }
}
