
import java.io.Serializable;
import java.time.LocalDate;

/*
Напишете клас Movie, който да има характеристиките заглавие (title), режисьор (director), 
масив с актьори (actors) и дата на издаване (releaseDate). Нека заглавието и имената на режисьора 
и актьорите са от тип String.
 */
public class Movie implements Serializable{
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
    
    
}
