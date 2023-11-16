/*
name: Julian O'Grady
course: ICS4UO
Assignment: Linked List Palindrome
Due date: October 13th 2023
Program Description: A program that checks if a string is a palindrome using a linked list with a user friendly UI
*/


public class LinkedChar {
    public LinkedChar next;
    public LinkedChar prev;
    public char data;

    // constructor with data character
    public LinkedChar(char data) {
        this.data = data;
    }

    // set next
    public void setNext(LinkedChar next) {
        this.next = next;
    }

    // set prev
    public void setPrev(LinkedChar prev) {
        this.prev = prev;
    }
}
