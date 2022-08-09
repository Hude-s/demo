package demo6;

import java.lang.annotation.Annotation;

public class Che implements Check{
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

}
