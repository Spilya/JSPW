package pet.spilya.api;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SPWRequests {

    public static String sendRequest(String urlString, RequestType requestType, String bearerKey, String json) throws SPWException {
        try {
            URL url = new URL(urlString);
            OkHttpClient client = new OkHttpClient();
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = null;
            if (json != null) {
                body = RequestBody.create(JSON, json);
            }
            Request.Builder request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer " + bearerKey);
            switch (requestType) {
                case GET:
                    request.get();
                    break;
                case PUT:
                    request.put(body);
                    break;
                case POST:
                    request.post(body);
                    break;
            }
            try {
                Response response = client.newCall(request.build()).execute();
                if (response.code() == 200 || response.code() == 201) {
                    return response.body().string();
                } else if (response.code() == 401 || response.code() == 400 || response.code() == 404) {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    throw new SPWException("statusCode: " + jsonObject.getInt("statusCode") + " | error: " + jsonObject.getString("error") + " | message: " + jsonObject.getString("message"));
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        throw new SPWException("statusCode: " + jsonObject.getInt("statusCode") + " | error: " + jsonObject.getString("error") + " | message: " + jsonObject.getString("message"));
                    } catch (MalformedURLException e) {
                        throw new SPWException("errorCode: " + response.code());
                    }
                }
            } catch (IOException e) {
                throw new SPWException("API is not available");
            }
        } catch (MalformedURLException e) {
            throw new SPWException("API URL ERROR");
        }
    }
}
