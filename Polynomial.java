import java.util.*; 

// 1st Number: 5x^2+4x^1+2x^0 
// 2nd Number: -5x^1-5x^0 
public class Polynomial { 

	// Driver code 
	public static void main(String args[]) 
	{ 
		// 1st Number: 5x^2+4x^1+2x^0 
		Node poly1 = new Node(5, 2); 
		append(poly1, 4, 1); 
		append(poly1, 2, 0); 

		// 2nd Number: -5x^1-5x^0 
		Node poly2 = new Node(-5, 1); 
		append(poly2, -5, 0); 

		Node sum = addPolynomial(poly1, poly2); 
		for (Node ptr = sum; ptr != null; ptr = ptr.next) { 
			// printing polynomial 
			System.out.print(ptr.coeff + "x^"
							+ ptr.pow); 
			if (ptr.next != null) 
				System.out.print(" + "); 
		} 
		System.out.println(); 
	} 

	// insert in linked list 
	public static void append(Node head, int coeff, 
							int power) 
	{ 
		Node new_node = new Node(coeff, power); 
		while (head.next != null) { 
			head = head.next; 
		} 
		head.next = new_node; 
	} 

	/* The below method print the required sum of polynomial 
	p1 and p2 as specified in output */
	public static Node addPolynomial(Node p1, Node p2) 
	{ 
		Node res = new Node( 
			0, 0); // dummy node ...head of resultant list 
		Node prev 
			= res; // pointer to last node of resultant list 
		while (p1 != null && p2 != null) { 
			if (p1.pow < p2.pow) { 
				prev.next = p2; 
				prev = p2; 
				p2 = p2.next; 
			} 
			else if (p1.pow > p2.pow) { 
				prev.next = p1; 
				prev = p1; 
				p1 = p1.next; 
			} 
			else { 
				p1.coeff = p1.coeff + p2.coeff; 
				prev.next = p1; 
				prev = p1; 
				p1 = p1.next; 
				p2 = p2.next; 
			} 
		} 
		if (p1 != null) { 
			prev.next = p1; 
		} 
		else if (p2 != null) { 
			prev.next = p2; 
		} 
		return res.next; 
	} 
} 

/* Link list Node */
class Node { 
	public int coeff; 
	public int pow; 
	public Node next; 

	public Node(int c, int p) 
	{ 
		this.coeff = c; 
		this.pow = p; 
		this.next = null; 
	} 
} 

// This code is contributed by Tapesh(tapeshdua420)
