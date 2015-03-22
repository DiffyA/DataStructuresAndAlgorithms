package exercise9;

public class Test {
	public static void main(String[] args) {
		Expression one = new Expression("2+2");
		Expression two = new Expression("(2+2)");
		Expression three = new Expression("2+2)");
		Expression four = new Expression("()(){2+2}");
		Expression five = new Expression("()()[{}{}2+2}}}");
		Expression six = new Expression("({[2+2]})");
		
		System.out.println(one.balancer());
		System.out.println(two.balancer());
		System.out.println(three.balancer());
		System.out.println(four.balancer());
		System.out.println(five.balancer());
		System.out.println(six.balancer());
		
	}
}
