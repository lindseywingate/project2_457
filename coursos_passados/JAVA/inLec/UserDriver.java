public class UserDriver
{
	public static void main(String[] args)
	{
		System.out.println("\n");
		MinionUser bob = new MinionUser("bfrank", "whatsup", -1, "Bob Frank", 304, false);
		System.out.println(bob+"\n");
		MinionUser sally = new MinionUser("sjones", "hello", 2, "Sally Jones", -1, true);
		System.out.println(sally);
		System.out.println("Are the users the same?: "+ bob.equals(sally));
	}
}
