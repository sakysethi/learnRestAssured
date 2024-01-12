package Payload;

public class WeatherAPIPayload {

    public static String addPlacePayload(){

        return "{\n" +
                "    \"City\": \"Hyderabad\",\n" +
                "    \"Temperature\": \"25.51 Degree celsius\",\n" +
                "    \"Humidity\": \"94 Percent\",\n" +
                "    \"Weather Description\": \"mist\",\n" +
                "    \"Wind Speed\": \"1 Km per hour\",\n" +
                "    \"Wind Direction degree\": \" Degree\"\n" +
                "}";
    }

}
