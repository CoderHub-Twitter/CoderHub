import java.util.Scanner;

public class App {
  private static Scanner keyboardInput;
public static void main(String [] arg) {
	  
	  String q1 = "At what point should you stop while driving?\n"
			    + "(a)When traffic lights are red\n(b)when traffic lights are orange\n(c)when traffic are green\n";
	  
	  String  q2 = "Are you adviced to drink and drive?\n"
			     + "(a)No\n(b)Yes\n";
	  
	  Question [] questions = {
               new Question(q1, "a"),
               new Question(q2, "a")
	  };
	  takeTest(questions);
  
  
  }
  public static void takeTest(Question [] questions) {
	  
	  int score = 0;
	  keyboardInput = new Scanner(System.in);
	 
	  for(int i = 0; i < questions.length; i++) {
		  System.out.println(questions[i].prompt);
		  String answer = keyboardInput.nextLine();
		  if(answer.equals(questions[i].answer)) {
			  
			  score++;
			  
		  }
	  }
	  System.out.println("You got " + score + "/" + questions.length);
  }
  


}