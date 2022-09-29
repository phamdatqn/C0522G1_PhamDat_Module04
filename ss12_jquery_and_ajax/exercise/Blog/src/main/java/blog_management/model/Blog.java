package blog_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfWriting;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, String writer, Date dateOfWriting, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.dateOfWriting = dateOfWriting;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(Date dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
