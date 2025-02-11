import java.util.TimeZone;

public class TicketReservationSystem {
    
    class BookedTicket{
        private int ticketId;
        private String passengerName;
        private String movieName;
        private short seatNo;
        private TimeZone showTime;
        private BookedTicket next;

        public BookedTicket(int ticketId, String passengerName, String movieName, short seatNo, TimeZone showTime){
            this.ticketId = ticketId;
            this.passengerName = passengerName;
            this.movieName = movieName;
            this.seatNo = seatNo;
            this.showTime = showTime;
            this.next = null;
        }

    }

    private BookedTicket head;
    private int size;

    public TicketReservationSystem(){
        this.head = null;
        this.size = 0;
    }

    private void addAtEnd(BookedTicket newTicket){
        // circular linked list insertion at end

        if(head == null){
            head = newTicket;
            head.next = head;
        }else{
            BookedTicket temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        size++;
    }        

    private void removeById(int id){
        // circular linked list deletion by id

        if(head == null){
            return;
        }

        BookedTicket temp = head;
        BookedTicket prev = null;

        while(temp.next != head && temp.ticketId != id){
            prev = temp;
            temp = temp.next;
        }

        if(temp.ticketId == id){
            if(temp == head){
                if(temp.next == head){
                    head = null;
                }else{
                    BookedTicket last = head;
                    while(last.next != head){
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
            }else{
                prev.next = temp.next;
            }
            size--;
        }
        
    }

    private void displayCurrentTiket(){
        // circular linked list traversal

        if(head == null){
            System.out.println("No tickets booked yet.");
            return;
        }

        BookedTicket temp = head;
        do{
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Passenger Name: " + temp.passengerName);
            System.out.println("Movie Name: " + temp.movieName);
            System.out.println("Seat No: " + temp.seatNo);
            System.out.println("Show Time: " + temp.showTime);
            System.out.println();
            temp = temp.next;
        }while(temp != head);
    }

    private void searchByUserName(String name){
        // circular linked list search by passenger name

        if(head == null){
            System.out.println("No tickets booked yet.");
            return;
        }

        BookedTicket temp = head;
        boolean found = false;
        do{
            if(temp.passengerName.equals(name)){
                System.out.println("Ticket ID: " + temp.ticketId);
                System.out.println("Passenger Name: " + temp.passengerName);
                System.out.println("Movie Name: " + temp.movieName);
                System.out.println("Seat No: " + temp.seatNo);
                System.out.println("Show Time: " + temp.showTime);
                System.out.println();
                found = true;
            }
            temp = temp.next;
        }while(temp != head);

        if(!found){
            System.out.println("No tickets found for passenger name: " + name);
        }
    }

    private void totalNumberOfBookings(){
        System.out.println("Total number of bookings: " + size);
    }

    public static void main(String[] args) {
        
        System.out.println("Ticket Reservation System");
        System.out.println("**************************");

        TicketReservationSystem trs = new TicketReservationSystem();

        while(true){
            System.out.println("1. Book a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Display all tickets");
            System.out.println("4. Search by passenger name");
            System.out.println("5. Total number of bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(System.console().readLine());

            switch(choice){
                case 1:
                    System.out.print("Enter ticket ID: ");
                    int ticketId = Integer.parseInt(System.console().readLine());
                    System.out.print("Enter passenger name: ");
                    String passengerName = System.console().readLine();
                    System.out.print("Enter movie name: ");
                    String movieName = System.console().readLine();
                    System.out.print("Enter seat number: ");
                    short seatNo = Short.parseShort(System.console().readLine());
                    System.out.print("Enter show time: ");
                    String showTime = System.console().readLine();
                    trs.addAtEnd(trs.new BookedTicket(ticketId, passengerName, movieName, seatNo, TimeZone.getTimeZone(showTime)));
                    break;
                case 2:
                    System.out.print("Enter ticket ID to cancel: ");
                    int id = Integer.parseInt(System.console().readLine());
                    trs.removeById(id);
                    break;
                case 3:
                    trs.displayCurrentTiket();
                    break;
                case 4:
                    System.out.print("Enter passenger name to search: ");
                    String name = System.console().readLine();
                    trs.searchByUserName(name);
                    break;
                case 5:
                    trs.totalNumberOfBookings();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
        }

        

    }
}
}
