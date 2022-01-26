package ru.job4j.accident.model;

import java.util.Objects;

public class Accident {

    private int id;

    private String name;

    private String article;

    private String text;

    private String address;

    private AccidentType type;

    public Accident() {
    }

    public Accident(int id, String name, String article, String text, String address) {
        this.id = id;
        this.name = name;
        this.article = article;
        this.text = text;
        this.address = address;
    }

    public static Accident of(int id, String name, String article, String text, String address) {
        Accident accident = new Accident();
        accident.id = id;
        accident.name = name;
        accident.article = article;
        accident.text = text;
        accident.address = address;
        return accident;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id && Objects.equals(name, accident.name)
                && Objects.equals(text, accident.text)
                && Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address);
    }

    @Override
    public String toString() {
        return "Accident{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", article='" + article + '\''
                + ", text='" + text + '\''
                + ", address='" + address + '\''
                + ", accidentType='" + type + '\''
                + '}';
    }
}
