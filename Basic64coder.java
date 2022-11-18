public class Basic64coder
	{
		public static void main(String[] args)
			{
				String a = "Hallo"; //Text, that has to be encoded
				String b = "";		//The text in ASCII - Decimals
				String c = "";
				String d = "";
				String e = "";
				for (int i=0; i!=a.length(); i++)
					{
						b = b + (int) a.charAt(i) + " ";
					}
				System.out.println(a);
				System.out.println(b);
				for (int i=0; i!=b.length(); i++)
					{
						c = "";
						d = "";
						if (b.charAt(i) == ' ')
							{
							}
						else
							{
								while (b.charAt(i) != ' ')
									{
										c = c + b.charAt(i);
										i++;
									}
								int integer = Integer.parseInt(c);
								while (integer != 0)
									{
										d = d + (integer % 2);
										integer = (integer - (integer % 2)) / 2;
									}
								for (int k = d.length() - 1;  k != -1; k--)
									{
										e = e + d.charAt(k);
									}
							}
					}
				System.out.println(e);
			}
	}
