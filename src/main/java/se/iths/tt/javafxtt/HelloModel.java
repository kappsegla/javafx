package se.iths.tt.javafxtt;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HelloModel {

    final HttpClient client = HttpClient.newHttpClient();
    final Executor executor = Executors.newSingleThreadExecutor();
    private final StringProperty quote = new SimpleStringProperty();
    private final StringProperty url = new SimpleStringProperty();

    public String getQuote() {
        return quote.get();
    }

    public StringProperty quoteProperty() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote.set(quote);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public void loadNewQuote() {
        String _url = getUrl();
        Task<String> task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(_url))
                        .GET() // GET is default
                        .build();

                HttpResponse<String> response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200)
                    throw new RuntimeException("Error getting quote");

                return response.body();
            }
        };

        //Register for events from task. Will run on gui thread
        task.setOnScheduled(event -> setQuote("Started..."));
        task.setOnSucceeded(event -> setQuote(task.getValue()));
        task.setOnFailed(event -> setQuote("Failed"));

        executor.execute(task);
    }
}
