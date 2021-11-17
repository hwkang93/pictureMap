package hwkang.pictureMap.annotation.loginUser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//Annotation type
@Target(ElementType.PARAMETER)

// Indicates how long annotations with the annotated type are to be retained
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
