import javax.naming.NameNotFoundException;

public class MovieManagementSystem {
    private int size;

    class Movie{
        private String title;
        private String director;
        private String yearOfRelease;
        private float rating;
        private Movie next;
        private Movie previous;
        public Movie(String title, String director, String yearOfRelease, float rating) {
            this.title = title;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.next = null;
            this.previous=null;
        }
    }
    private Movie head;
    private Movie tail;

    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
        this.size=0;
    }

    public void addMovieAtBeginning(String title, String director, String yearOfRelease, float rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.previous = newMovie;
            head = newMovie;
        }
        size++;
    }

    public void addMovieAtLast(String title, String director, String yearOfRelease, float rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.previous = tail;
            tail = newMovie;
        }
        size++;
    }

    public void addAtPostion(String title, String director, String yearOfRelease, float rating, int position) {
        if (position == 0) {
            this.addMovieAtBeginning(title, director, yearOfRelease, rating);
        } else {
            Movie newMovie = new Movie(title, director, yearOfRelease, rating);
            Movie temp = head;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newMovie.next = temp.next;
                newMovie.previous = temp;
                temp.next = newMovie;
                if (newMovie.next != null) {
                    newMovie.next.previous = newMovie;
                }
            }
        }
        size++;
    }
   
    public void removeByTitle(String title) throws NameNotFoundException{
        Movie frontPtr = head;
        Movie backPtr = tail;
        int count=0;

       if (head.title.equals(title)) {
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null; 
        }
        size--;
        return;
    }

        while(frontPtr!=null && frontPtr.next!=null){ 
            if(frontPtr.title.equals(title)){
                count=1;
                break;
            }
            else if(backPtr.title.equals(title)){
                count=2;
                break;
            }else if(backPtr==frontPtr){break;}
        
                frontPtr = frontPtr.next;
                backPtr = backPtr.previous;
            
        }
        if(count != 0 ){
            if(count==1){
                if(frontPtr==head){
                    head = head.next;
                    head.previous = null;
                }else if(frontPtr==tail){
                    tail = tail.previous;
                    tail.next = null;
                }else{
                    frontPtr.previous.next = frontPtr.next;
                    frontPtr.next.previous = frontPtr.previous;
                }
            }else if(count==2){
                if(backPtr==head){
                    head = head.next;
                    head.previous = null;
                }else if(backPtr==tail){
                    tail = tail.previous;
                    tail.next = null;
                }else{
                    backPtr.previous.next = backPtr.next;
                    backPtr.next.previous = backPtr.previous;
                }
            }
            size--;
        }
        else{
            throw new NameNotFoundException();
        }

    }
   
    public void searchMovie(String director,float rating){
        Movie tempHead = head;
        Movie tempTail = tail;

        while(tempHead!=null && tempTail!=null){
            if(tempHead.director.equals(director) || tempHead.rating>=rating){
                System.out.println("Title: "+tempHead.title);
                System.out.println("Director: "+tempHead.director);
                System.out.println("Year of Release: "+tempHead.yearOfRelease);
                System.out.println("Rating: "+tempHead.rating);
                System.out.println("---------------------------------------");
                break;
            }
            else if(tempTail.director.equals(director) || tempTail.rating>=rating){
                System.out.println("Title: "+tempTail.title);
                System.out.println("Director: "+tempTail.director);
                System.out.println("Year of Release: "+tempTail.yearOfRelease);
                System.out.println("Rating: "+tempTail.rating);
                System.out.println("---------------------------------------");
            }
            tempHead = tempHead.next;
            tempTail = tempTail.previous;
        }

    }

    private void printMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year of Release: " + temp.yearOfRelease);
            System.out.println("Rating: " + temp.rating);
            System.out.println("---------------------------------------");
            temp = temp.next;
        }
    }

    private void printMoviesReverse(){
        Movie temp = tail;
        while(temp!=null){
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year of Release: " + temp.yearOfRelease);
            System.out.println("Rating: " + temp.rating);
            System.out.println("---------------------------------------");
            temp = temp.previous;
        }
    }

    private void updateRating(String title){
        Movie temp = head;
        while(temp!=null){
            if(temp.title.equals(title)){
                temp.rating = 10.0f;
                break;
            }
            temp = temp.next;
        }

    }
    public static void main(String[] args) {
        MovieManagementSystem movieManagementSystem = new MovieManagementSystem();

        System.out.println("Movies are being added to the list");
        System.out.println("---------------------------------------");

        movieManagementSystem.addMovieAtBeginning("The Shawshank Redemption", "Frank Darabont", "1994", 9.3f);
        movieManagementSystem.addMovieAtLast("The Godfather", "Francis Ford Coppola", "1972", 9.2f);
        movieManagementSystem.addAtPostion("The Dark Knight", "Christopher Nolan", "2008", 9.0f, 1);

        System.out.println("Movies are added to the list");
        System.out.println("---------------------------------------");

        System.out.println("Searching for the movie with director name or rating");
        System.out.println("---------------------------------------");
        movieManagementSystem.searchMovie("Christopher Nolan", 8.0f);
        
        System.out.println("Movies in forward order");
        System.out.println("---------------------------------------");
        movieManagementSystem.printMoviesForward();

        System.out.println("Updating the rating of the movie");
        System.out.println("---------------------------------------");
        movieManagementSystem.updateRating("The Dark Knight");

        System.out.println("Movies in reverse order");
        System.out.println("---------------------------------------");
        movieManagementSystem.printMoviesReverse();

        System.out.println("Removing the movie by title");
        System.out.println("---------------------------------------");
        try {
            movieManagementSystem.removeByTitle("The Godfather");
        } catch (NameNotFoundException e) {
            System.out.println("Movie not found");
        }
    }
}
