package enigma_camp.belajar_restful_api.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PersonApp {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("Farid");
        person.setAge(20);

        Address address = new Address();
        address.setCity("Bandung");
        address.setCountry("Indonesia");

        person.setAddress(address);
        System.out.println(person);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
