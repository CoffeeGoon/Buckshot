import java.util.Scanner;
	import java.io.*;
	import java.util.ArrayList;


	
	import java.util.Random;


public class Buckshot {



	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir").toString());
		
		ArrayList<String> emails = new ArrayList<String>();
		emails.add( "@gmail.com");
		emails.add("@yahoo.com");
		emails.add("@hotmail.com");
		emails.add("@outlook.com");
		Scanner mnames;
		Scanner fnames;
		Scanner lnames;
		ArrayList<String> malenam = new ArrayList<String>();
		ArrayList<String> femnam = new ArrayList<String>();
		ArrayList<String> lastnam = new ArrayList<String>();
		
		try {
		 mnames = new Scanner(new File("malefnames.txt"));
		 while(mnames.hasNext()) {
				String token = mnames.next();
				if(token.matches("[A-Z]+")) {
					malenam.add(token);
				}
			}
		} catch(Exception e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		
		try {
			 fnames = new Scanner(new File("femalefnames.txt"));
			 while(fnames.hasNext()) {
					String token = fnames.next();
					if(token.matches("[A-Z]+")) {
						femnam.add(token);
					}
				}
			} catch(Exception e) {
				System.out.println(e.toString());
				System.exit(-1);
			}
		try {
			 lnames = new Scanner(new File("lastnames.txt"));
			 while(lnames.hasNext()) {
					String token = lnames.next();
					if(token.matches("[A-Z]+")) {
						lastnam.add(token);
					}
				}
			} catch(Exception e) {
				System.out.println(e.toString());
				System.exit(-1);
			}
		int trials = 100;
		ArrayList<String> addresses = new ArrayList<String>();
		Random firstch = new Random();

		for(int i = 0; i < trials; i++) {
			int gender = firstch.nextInt(2);
			int lpos = firstch.nextInt(lastnam.size());
			int fpos = 0;
			String addr = "";
			if(gender == 0) {
				addr = femnam.get(firstch.nextInt(femnam.size())).toLowerCase();
			}
			else {
				addr =  malenam.get(firstch.nextInt(malenam.size())).toLowerCase();
			}
			addr = addr + "." + lastnam.get(lpos).toLowerCase();
			int hostyp = firstch.nextInt(4);
			addr = addr + emails.get(hostyp);
			addresses.add(addr);
		}
		
		
		appframe gui = new appframe(addresses);
		gui.setVisible(true);
		
		
	}

	}

