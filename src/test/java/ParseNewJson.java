import org.json.JSONObject;

public class ParseNewJson {
    public static void main(String[] args) {
//        String jsonString = "{\n" +
//                "  \"book\": {\n" +
//                "    \"title\": \"The Great Gatsby\",\n" +
//                "    \"author\": \"F. Scott Fitzgerald\",\n" +
//                "    \"published_year\": 1925,\n" +
//                "    \"genres\": [\"Fiction\", \"Classic Literature\"],\n" +
//                "    \"isbn\": \"9780743273565\",\n" +
//                "    \"publisher\": {\n" +
//                "      \"name\": \"Scribner\",\n" +
//                "      \"location\": \"New York\"\n" +
//                "    },\n" +
//                "    \"language\": \"English\",\n" +
//                "    \"pages\": 180,\n" +
//                "    \"price\": 9.99,\n" +
//                "    \"available\": true\n" +
//                "  }\n" +
//                "}";
//
//
//        JSONObject jsonObject = new JSONObject(jsonString);
//        System.out.println(jsonObject.getJSONObject("book").getJSONArray("genres").get(1));

        String jsonBody = "{\n" +
                "  \"book\": [\n" +
                "    {\n" +
                "      \"author\": \"Nigel Rees\",\n" +
                "      \"category\": \"reference\",\n" +
                "      \"price\": 8.95,\n" +
                "      \"title\": \"Sayings of the Century\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JSONObject jsonObject = new JSONObject(jsonBody);
        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            System.out.println(jsonObject.getJSONArray("book").getJSONObject(0).get("title").toString());
        }
    }
}