import java.util.Scanner;
    class TicketNumber implements Runnable {
        int max=100;
        int min=1;
        @Override
        public void run() {
            int ticketNumber = (int)(Math.random()*(max-min+1)+min);
        }
    }


    class destination
    {

        Scanner in=new Scanner(System.in);
        public int count;
        public  int available[]=new int[] {20,20,20,20,20,20};

        public String check;
        public void visit()
        {

            System.out.println("*************");
            System.out.println("*   DESTINATION   |  FARE  |  SEAT  *");
            System.out.println("*************");
            System.out.println("* 1.)Karachi       | 4000 Rs |   "+available[1]+"   *");
            System.out.println("* 2.)Islamabad     | 8000 Rs |   "+available[2]+"   *");
            System.out.println("* 3.)Rawalpindi    | 7000 Rs |   "+available[3]+"   *");
            System.out.println("* 4.)Lahore        | 8000 Rs |   "+available[4]+"   *");
            System.out.println("* 5.)Gilgit        | 10000 Rs |   "+available[5]+"   *");
            System.out.println("*************");
            System.out.println("*************\n");

            System.out.print("Do you want another transaction? [Y/N]: ");
            check=in.nextLine();
            if(check=="y")
            {

            }
            else
            {
                if(check.equalsIgnoreCase("n"))
                {   System.exit(0);

                }
            }


        }
    }

    class GenerateTicketNumber {
        int max=100;
        int min=1;
        int ticketNumber;
        public void generateTicketId(){
            this.ticketNumber = (int)(Math.random()*(max-min+1)+min);
        }
        public int returnTicketId(){
            return this.ticketNumber;
        }
    }

    class passengers extends destination
    {

        Scanner sc=new Scanner(System.in);
        public  static String name[]=new String[100];
        public  static int place[]=new int[100];
        public  static int tourist[]=new int[20];
        public  static double fare[] = { 0, 4000,8000,7000,8000,10000};
        public  static String dest[] = { " ", "Karachi", "Islamabad", "Rawalpindi", "Lahore", "Gilgit"};
        public int u=1;
        public  static int price=1;
        public  static int n;
        public  static int d=1;
        public int to;
        public  static int pas_c=1;
        public static double bill[]=new double[200];
        public static int q;

        GenerateTicketNumber ticket1 = new GenerateTicketNumber();
        void accept()
        {

            System.out.println("*************");
            System.out.println("*   DESTINATION   |  FARE  |  SEATS AVAILABLE  *");
            System.out.println("*************");
            System.out.println("* 1.)Karachi        | 4000 Rs |   "+available[1]+"   *");
            System.out.println("* 2.)Islamabad      | 8000 Rs |   "+available[2]+"   *");
            System.out.println("* 3.)Rawalpindi     | 7000 Rs |   "+available[3]+"   *");
            System.out.println("* 4.)Lahore         | 8000 Rs |   "+available[4]+"   *");
            System.out.println("* 5.)Gilgit        | 10000 Rs |   "+available[5]+"   *");
            System.out.println("*************");
            System.out.println("*************\n");


            if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0))
            {
                System.out.println("Sorry, We don't  have available seats for all Destination!");
            }
            else
            {

                System.out.println("Enter your name:");
                name[n]=sc.next();


                System.out.println("ENTER DESTINATION [number]:");
                to=sc.nextInt();
                d=to;

                u=d;
                price=u;


                if(d<1||d>5)
                {
                    System.out.println("Invalid Input!");
                    System.exit(0);
                }

                System.out.println("How many passengers are you:");

                tourist[pas_c]=sc.nextInt();


                available[u] = available[u]-tourist[pas_c];

                TicketNumber ticketNumber = new TicketNumber();
                if(available[u]<0)
                {
                    System.out.print("Sorry, We don't have seat available for " +tourist[pas_c] +" person\n");
                    available[u] = available[u]+tourist[pas_c];
                    System.out.println("We only have seats for "+ available[u] +" passengers available");
                }
                ticket1.generateTicketId();
                TicketNumber ticketNumber1 = new TicketNumber();
                Thread ticket = new Thread(ticketNumber1);
                ticket.setPriority(10);
                System.out.println("\n***************");
                System.out.println("*        PASSENGER'S DETAILS        *");
                System.out.println("*************");
                System.out.println("PASSENGER'S NAME: " +  name[n]);
                System.out.println("PASSENGER'S DESTINATION : " +  dest[d]);
                System.out.println("FARE PRICE: " + fare[price]);
                System.out.println("NO. OF PASSENGERS: " + tourist[pas_c]);
                System.out.println("YOUR TICKET NUMBER IS : " + ticket1.returnTicketId());
                ticket.start();
                System.out.println();
                System.out.println("*************");
                System.out.println("*************\n");

                bill[q]=fare[price]*tourist[pas_c];

                System.out.print("Do you want another transaction? [Y/N]: ");
                check=in.nextLine();
                if(check=="y")
                {

                }
                else
                {
                    if(check.equalsIgnoreCase("n"))
                    {
                        System.exit(0);

                    }
                }

            }
        }

    }



    class billing extends passengers
    {
        Scanner in=new Scanner(System.in);
        String search;
        public  static String check="checked";
        public double pay[]=new double[150];
        public int money;
        public String again;
        public void bill()
        {


            System.out.print("ENTER PASSENGER'S NAME: ");
            search=in.nextLine();

            if(search.equalsIgnoreCase(name[n]))
            {
                System.out.println("\n***************");
                System.out.println("*        PASSENGER'S DETAILS        *");
                System.out.println("*************");
                System.out.println("PASSENGER'S NAME: " +  name[n]);
                System.out.println("PASSENGER'S DESTINATION : " +  dest[d]);
                System.out.println("FARE PRICE:  " + fare[price]);
                System.out.println("NO. OF PASSENGERS: " + tourist[pas_c]);
                System.out.println("TICKET NUMBER : " + ticket1.returnTicketId());
                System.out.println();
                System.out.println("*************");
                System.out.println("*************\n");


                if(check=="paid")
                {
                    System.out.println("Passenger's Already Paid!");

                }
                else
                {
                    System.out.println("\nPASSENGER'S TOTAL FARE:  "+bill[q]);
                    System.out.print("ENTER AMOUNT TO PAY: ");
                    pay[money]=in.nextInt();

                    if(pay[money]<0||pay[money]<bill[q])
                    {
                        System.out.println("Invalid Input!");
                    }
                    else
                    {
                        System.out.println("You have succesfully paid your amount!!");
                        System.out.println("*************\n");
                        check="paid";
                    }

                }

            }
            else
            {
                System.out.println("\nPASSENGER'S NAME NOT FOUND!\n");
            }
            System.out.print("Do you want another transaction? [Y/N]: ");
            again=in.nextLine();
            if(again=="y")
            {

            }
            else
            {
                if(again.equalsIgnoreCase("n"))
                {
                    System.exit(0);

                }

            }
        }
    }



    class view extends billing
    {
        public String search;

        Scanner sc=new Scanner(System.in);
        public String input;

        public void data()
        {

            System.out.print("SEARCH PASSENGER'S NAME: ");
            search=sc.nextLine();
            try
            {
                if(search.equalsIgnoreCase(name[n]))
                {

                    System.out.println("\n***************");
                    System.out.println("*        PASSENGER'S DETAILS        *");
                    System.out.println("*************");
                    System.out.println("PASSENGER'S NAME: " +  name[n]);
                    System.out.println("PASSENGER'S DESTINATION : " +  dest[d]);
                    System.out.println("FARE PRICE: " + fare[price]);
                    System.out.println("NO. OF PASSENGERS: " + tourist[pas_c]);
                    System.out.println("TICKET NUMBER : " + ticket1.returnTicketId());
                    System.out.println();
                    System.out.println("*************");
                    System.out.println("*************\n");

                    if(check.equals("paid"))
                    {
                        System.out.println("Amount :"+bill[q]);
                        System.out.println("STATUS: PAID");
                    }
                    else
                    {
                        System.out.println("STATUS: NOT PAID");
                        System.out.println("*************");
                        System.out.println("*************");
                    }

                }
                else
                {
                    System.out.println("Passenger's Name not found!");
                }
            }

            catch(Exception e)
            {
                System.out.println("There was error while displaying the bill!");
            }

            System.out.print("Do you want another transaction? [Y/N]: ");
            again=in.nextLine();
            if(again=="y")
            {

            }
            else
            {
                if(again.equalsIgnoreCase("n"))
                {
                    System.exit(0);

                }
            }

        }
    }




    public class Bus extends view {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int i;


            Bus b = new Bus();

            {
                while (true) {
                    System.out.println("****************");
                    System.out.println("*        BUS RESERVATION SYSTEM   *");
                    System.out.println("****************");
                    System.out.println("* [1] Destination                   *");
                    System.out.println("* [2] Make a Reservation            *");
                    System.out.println("* [3] Billing                       *");
                    System.out.println("* [4] View Records                  *");
                    System.out.println("* [5] Exit                          *");
                    System.out.println("*************");
                    System.out.println("*************\n");
                    System.out.println("Enter your choice: ");
                    i = in.nextInt();
                    switch (i) {
                        case 1:
                            b.visit();

                            break;

                        case 2:
                            b.accept();
                            break;

                        case 3:
                            b.bill();
                            break;

                        case 4:
                            b.data();

                            break;

                        default:
                            System.exit(0);
                            break;
                    }
                }
            }
        }
    }

