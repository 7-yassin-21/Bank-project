import java.sql.SQLOutput;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int account_mangment = 0, id = 0, i = 0;
        String emails[] = new String[100];
        String passwords[] = new String[100];
        String user_names[] = new String[100];
        String passwords_confirm[] = new String[100];
        String phone_numbers[] = new String[100];
        int Ids[] = new int[100];
        boolean search_by_user=false;

        do {

            System.out.println("type a number you see to select the operation.");
            System.out.println("1:create account\t2:find account\t3:search recipent.");
            System.out.println("4:update account\t5:view account details\t 0:exit");
            account_mangment = input.nextInt();

            switch (account_mangment) {

                case 0:
                    System.out.println("exiting...");
                    break;

                case 1:
                    create_account(Ids, id, emails, passwords, user_names, phone_numbers,passwords_confirm, input);
                    break;

                case 2:
                    search_user(emails, user_names, Ids, phone_numbers, input);
                    break;

                case 3:

                case 4:
                    update_account(emails, Ids, passwords, passwords_confirm, user_names, phone_numbers,input);
                    break;

                case 5:
                    account_details_user(emails,passwords,phone_numbers,user_names,input);
                    break;

            }
        } while (account_mangment != 0);
    }

    //  case 2
    public static void search_user (String[]emails, String[]user_names,int[] Ids, String[] phone_numbers, Scanner
            input){
        System.out.println("please enter the email you want to search for.");
        String email_search = input.next();
        boolean search_by_user = false;
        int s = 0;
        for (int i = 0; i < emails.length; i++) {

            if (email_search.equals(emails[i])) {
                search_by_user = true;
                s = i;
            }
        }
        if (search_by_user == true) {
            System.out.println("Account found\n↓Account Details↓");
            System.out.println("email: " + emails[s]);
            System.out.println("user: " + user_names[s]);
            System.out.println("id: " + Ids[s]);
            System.out.println("phone number: " + phone_numbers[s]);
            System.out.println("Balance and password are only visible to admin.");
        } else System.out.println("account does not exist");
    }

    //  case 1
    public static void create_account ( int[] Ids, int id, String[] emails, String[]passwords, String[]
            user_names, String[]phone_numbers, String[] passwords_confirm, Scanner input){
        int i;
        id++;

        System.out.println("your id is"+Ids[id]);
        System.out.println("please enter your email.");
        emails[id] = input.next();

        do {
            if (!emails[id].contains("@gmail.com"))
            {
                System.out.println("invaild,try again.");
                emails[id] = input.next();
            }
        } while (!emails[id].contains("@gmail.com"));

        System.out.println("please enter your password.");
        passwords[id] = input.next();

        do {
            System.out.println("please confirm your password.");
            passwords_confirm[id] = input.next();
            if (passwords[id].equals(passwords_confirm[id])) {
                continue;
            } else {
                System.out.println("please enter your password  then confirm it. ");
            }
            passwords[id] = input.next();
        } while (!passwords[id].equals(passwords_confirm[id]));

        System.out.println("please enter your user name.");
        user_names[id] = input.next();


        do {
            System.out.println("please enter your phone number .");
            phone_numbers[id] = input.next();
            if (phone_numbers[id].length() == 11 && phone_numbers[id].startsWith("0")) {
                break;
            } else {
                System.out.println("invalid phone number. please  try again.");
            }
        } while (true);

        System.out.println("Account successfully created.");

    }

    //  case 4
    public static void update_account (String[]emails,int[] Ids, String[] passwords, String[]
            passwords_confirm, String[]user_names, String[]phone_numbers, Scanner input){
        System.out.println("please enter the your email.");
        String email_update = input.next();
        boolean update_by_user = false;
        int s = 0, i = 0, id = 0;
        for (i = 0; i < emails.length; i++) {

            if (email_update.equals(emails[i])) {
                update_by_user = true;
                id = i;
            }
        }
        if (update_by_user == true) {
            System.out.println("please note that \"Ids\" cannot be changed and your id is:" + Ids[id]);
            System.out.println("please choose what do you want to change.");
            System.out.println("1:email\t2:password:\t3:user name:\t4:phone number:");
            int account_update = input.nextInt();
            switch (account_update) {
                case 1:
                    System.out.println("please type the new email.");
                    emails[id] = input.next();
                    System.out.println("email has been updated.");
                    break;
                case 2:
                    System.out.println("please type the new password.");
                    passwords[id] = input.next();

                    do {
                        System.out.println("please confirm your password.");
                        passwords_confirm[id] = input.next();
                        if (passwords[id].equals(passwords_confirm[id])) {
                            continue;
                        } else {
                            System.out.println("please enter your password  then confirm it. ");
                        }
                        passwords[id] = input.next();
                    } while (!passwords[id].equals(passwords_confirm[id]));
                    System.out.println("password updated.");
                    break;
                case 3:
                    System.out.println("please type the new user.");
                    user_names[id] = input.next();
                    System.out.println("user name updated.");
                    break;
                case 4:

                    do {
                        System.out.println("please type the new phone number.");
                        phone_numbers[id] = input.next();
                        if (phone_numbers[id].length() == 11 && phone_numbers[id].startsWith("0")) {
                            break;
                        } else {
                            System.out.println("invalid phone number, please try again.");
                        }
                    } while (true);
                    System.out.println("phone number updated.");
                    break;
            }
        }
    }

    //  case 5    add balance variable to the deatils↓↓↓
    public static void account_details_user (String[]emails, String[]passwords, String[]phone_numbers, String[]
            user_names, Scanner input){
        System.out.println("please enter your email.");
        String user_email = input.next();
        boolean search_by_user = false;
        int id = 0, i = 0;

        for (i = 0; i < emails.length; i++) {
            if (user_email.equals(emails[i])) {
                search_by_user = true;
                id = i;
            }
        }

        if (search_by_user == true) {
            System.out.println("enter your password.");
            String password_user_details = input.next();
            if (passwords[id].equals(password_user_details)) {
                System.out.println("email:" + emails[id]);
                System.out.println("password:" + passwords[id]);
                System.out.println("user:" + user_names[id]);
                System.out.println("balance:");
                System.out.println("phone number:" + phone_numbers[id]);
            } else
                do {
                    System.out.println("password does not match, please try again.");
                    password_user_details = input.next();
                } while (!password_user_details.equals(passwords[id]));
            System.out.println("email:" + emails[id]);
            System.out.println("password:" + passwords[id]);
            System.out.println("user:" + user_names[id]);
            System.out.println("balance:");
            System.out.println("phone number:" + phone_numbers[id]);
        }
    }

}
