package RSA;

public class LibraryApiPayload {
    
    public static String addBook(){

        String addBookPayload = "{\r\n" + //
                "\r\n" + //
                "\"name\":\"Learn Appium Automation with Java\",\r\n" + //
                "\"isbn\":\"bcd\",\r\n" + //
                "\"aisle\":\"2287\",\r\n" + //
                "\"author\":\"John foe\"\r\n" + //
                "}\r\n" + //
                "";

                return addBookPayload;
    }
}
