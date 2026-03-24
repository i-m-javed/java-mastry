package Exceptions;

public class underAge {

	public static void main(String[] args) throws underAgeException {
		// TODO Auto-generated method stub
		int age=27;
		if(age<18) {
			throw new underAgeException("You are under age");
		}

	}

}
