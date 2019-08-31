package br.com.guedes.elegantez.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "eleganteMail")
public class ElegantMail implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String message;

    public ElegantMail() {}

    public ElegantMail(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}