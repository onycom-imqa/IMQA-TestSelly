package imqa;

import java.util.Map;

public class ObjectMapper<T> {

    public T convert(Class<T> mappingClass, Map<String,String> dataObject) throws Exception {
        T instance = mappingClass.getDeclaredConstructor().newInstance();
        // map dataObject to instance using reflection or other mapping libraries
        return instance;
    }
}
