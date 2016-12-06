
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 Напишете програма Task0_SaveObjectsToFiles, в която инстанцирайте един обект от тип Movie
и въведете съответните стойности. Нека програмата да запамети обекта във файл, използвайки 
файлов поток (FileStream) и обектен поток (ObjectStream). Опитайте се, отново използвайки 
същите потоци, да прочетете съдържанието на файла и да преобразувате данните обратно към 
обект от тип Movie. Проверете дали данните съвпадат.
 */
public class Task0_SaveObjectsToFiles {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String title = "James Cameron";
        String director = "James Cameron";
        String[] actors = {"Leonardo DiCaprio", "Kate Winslet", "Billy Zane"};
        String releaseDate = "11.12.1997";
        Movie movie = new Movie(title, director, actors, LocalDate.parse(releaseDate, formatter));

        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream("taskTest/Test.txt"))) {

            oos.writeObject(movie);
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream oos
                = new ObjectInputStream(new FileInputStream("taskTest/Test.txt"))) {
            Movie newMovie = (Movie) oos.readObject();

            System.out.println(movie.compareMovie(newMovie));
            //System.out.println(newMovie.director+" "+newMovie.title+" "+newMovie.releaseDate+" "+movie.releaseDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
