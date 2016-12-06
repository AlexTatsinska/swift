
import java.io.Serializable;
import java.time.LocalDate;

/*
Напишете клас Movie, който да има характеристиките заглавие (title), режисьор (director), 
масив с актьори (actors) и дата на издаване (releaseDate). Нека заглавието и имената на режисьора 
и актьорите са от тип String.
 */
public class Movie implements Serializable {
    
    public String title;
    public String director;
    public String[] actors;
    public LocalDate releaseDate;
    
    public Movie(String title, String director, String[] actors, LocalDate releaseDate) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
    }
    
    public boolean compareMovie(Movie newMovie) {
        boolean result = false;
        int counter = 0;
        if (this.title.equals(newMovie.title) && this.director.equals(newMovie.director) && this.releaseDate.isEqual(newMovie.releaseDate)) {
            for (int i = 0; i < this.actors.length; i++) {
                for (int j = 0; j < newMovie.actors.length; j++) {
                    if (this.actors[i].equals(newMovie.actors[j])) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == this.actors.length) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}
