package team5.book_manager.entities;

import javax.persistence.*;



@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "price")
    private int price;

    public BookEntity() {
    }

    public BookEntity(String name, String publisher, int price) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }

    public BookEntity(int id, String name, String publisher, int price) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
