
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CardsAnnotation {
    String type();
    String category();
    String description();

}
