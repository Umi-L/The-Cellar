/*
name: Julian O'Grady
course: ICS4UO
Assignment: Linked List Palindrome
Due date: October 13th 2023
Program Description: A program that checks if a string is a palindrome using a linked list with a user friendly UI
*/

import javax.swing.*;

public class Main {

	// window builder frame
	public static WindowBuilder frame;

	// string to check
	public static String toCheck = "";

	// entry point of program
	public static void main(String[] args) {
		// instantiate windowBuilder
		frame = new WindowBuilder();
		frame.setVisible(true); // show window
	}

	// function to check if the toCheck string is a palindrome
	public static void Check(){
		// previous linked char
		LinkedChar previous = null;

		// first and last linked char
		LinkedChar first = null;
		LinkedChar last = null;

		// foreach character in toCheck
		for(int i = 0; i < toCheck.length(); i++){

			// if not a letter or number skip
			if(!Character.isLetterOrDigit(toCheck.charAt(i))){
				continue; // skip
			}

			// get character at i to lower case to make it case-insensitive
			char lower = Character.toLowerCase(toCheck.charAt(i));

			// make new linked char
			LinkedChar current = new LinkedChar(lower);

			// set first linked char
			if (i == 0) {
				first = current; // set first
			}

			// set previous in linked char
			current.setPrev(previous);

			// get previous linked char and set next to current
			if(previous != null){
				previous.setNext(current); // set next
			}

			// set previous to current
			previous = current;
			last = current;
		}

		// iterate through linked list forward and backwards at the same time and check if the characters are the same
		LinkedChar forward = first;
		LinkedChar backward = last;

		// is Palindrome variable start as true and if a character is not the same set to false
		boolean isPalindrome = true;

		while(forward != null && backward != null){

			// if characters are not the same set isPalindrome to false and break
			if(forward.data != backward.data){
				isPalindrome = false; // set to false
				break;
			}

			// set forward and backward to next and prev
			forward = forward.next;
			backward = backward.prev;
		}

		// if isPalindrome is true show true popup
		if(isPalindrome){
			// show popup with palindrome text
			JOptionPane.showMessageDialog(frame, "Your text is a palindrome");
		} else { // if isPalindrome is false show popup
			// show popup with not palindrome text
			JOptionPane.showMessageDialog(frame, "Your text is not a palindrome");
		}
	}
}
