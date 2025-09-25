package io.book.library.domain.entities;

import io.book.library.domain.enums.BookStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "Book_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Book_Name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "Category_ID")
    private Category category;

    @Column(name = "Book_Page")
    private Integer pages;

    @Column(name = "Book_Image")
    private String coverImageUrl;

    @Column(name = "Book_summary")
    private String summary;

    @CreationTimestamp
    private LocalDate publishedDate;

    @CreationTimestamp
    private LocalDate returnDate;

    @CreationTimestamp
    private LocalDate dueDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updateAt;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    public Book() {

    }

    public Book(Long bookID, String bookName, Author author, Category category, Integer pages, String coverImageUrl, String summary, LocalDate publishedDate, LocalDateTime createdAt, LocalDateTime updateAt, LocalDate returnDate, LocalDate dueDate, BookStatus bookStatus) {
        this.id = bookID;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.coverImageUrl = coverImageUrl;
        this.summary = summary;
        this.publishedDate = publishedDate;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.bookStatus = bookStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

}
