import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Application {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> validUrl = getValidUrls();
        List<String> request = getRequest();

        String method = getMethod(request.get(0));
        String url = getUrl(request.get(0));

        Map<String, String> headers = getHeaders(request);
        Map<String, String> bodyParameters = getBodyParameters(request);

        createResponse(validUrl, url, headers, bodyParameters);
    }

    private static void createResponse(List<String> validUrl, String url, Map<String, String> headers,
                                       Map<String, String> bodyParameters) {
        StringBuilder response = new StringBuilder();

        if (validUrl.stream().anyMatch(x -> url.equals(x))) {
            response.append(String.format("HTTP/1.1 200 OK"))
                    .append(System.lineSeparator());

            headers.entrySet()
                    .stream()
                    .filter(e -> !e.getKey().equals("Authorization"))
                    .forEach(e -> {
                        response.append(String.format("%s: %s", e.getKey(), e.getValue()))
                                .append(System.lineSeparator());
                    });

            String name = decodeAutohrity(headers.get("Authorization").split("\\s+")[1]);

            response.append(System.lineSeparator())
                    .append(String.format("Greetings %s! You have successfully created ", name));

            if (bodyParameters.containsKey("name")) {
                response.append(String.format("%s with ", bodyParameters.get("name")));
            }

            bodyParameters.entrySet()
                    .stream()
                    .filter(e -> !e.getKey().contains("name"))
                    .forEach(e -> {

                response.append(String.format("%s – %s, ", e.getKey(), e.getValue()));
            });

            response.append(".");

        } else {
            response.append(String.format("HTTP/1.1 404  Not Found"))
                    .append(System.lineSeparator());

            headers.entrySet()
                    .stream()
                    .filter(e -> !e.getKey().equals("Authorization"))
                    .forEach(e -> {
                        response.append(String.format("%s: %s", e.getKey(), e.getValue()))
                                .append(System.lineSeparator());
                    });

            response.append("The requested functionality was not found.");
        }

        System.out.println(response.toString());
    }

    private static List<String> getValidUrls() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static List<String> getRequest() throws IOException {
        List<String> request = new ArrayList<String>();

        String line = null;
        while ((line = reader.readLine()) != null && line.length() > 0) {
            request.add(line);
        }
        request.add(System.lineSeparator());

        if ((line = reader.readLine()) != null && line.length() > 0) {
            request.add(line);
        }

        return request;
    }

    private static String getMethod(String line) {
        return line.split("\\s+")[0];
    }

    private static String getUrl(String line) {
        return line.split("\\s+")[1];
    }

    private static Map<String, String> getHeaders(List<String> request) {
        Map<String, String> headers = new LinkedHashMap<>();

        request.stream()
                .skip(1)
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKvp -> headers.put(headerKvp[0], headerKvp[1]));

        return headers;
    }

    private static Map<String, String> getBodyParameters(List<String> request) {
        Map<String, String> bodyParameters = new HashMap<>();

        if (request.get(request.size() - 1).equals("")) {
            return bodyParameters;
        }

        Arrays.stream(request.get(request.size() - 1)
                .split("&"))
                .map(bp -> bp.split("="))
                .forEach(bpKvp -> {
                    bodyParameters.put(bpKvp[0], bpKvp[1]);
                });


        return bodyParameters;
    }

    private static String decodeAutohrity(String authority) {
        byte[] decodedBytes = Base64.getDecoder().decode(authority);
        return new String(decodedBytes);
    }
}
