package cat.itacademy.s04.t02.n01.S04T02N01.model.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

}