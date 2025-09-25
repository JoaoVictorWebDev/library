package io.book.library.application.dto;

import io.book.library.application.dto.Abstraction.AbstractDTO;
import io.book.library.domain.entities.Author;
import io.book.library.domain.entities.Category;
import io.book.library.domain.enums.BookStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookDTO extends AbstractDTO {

    private String bookName;
    private Author author;
    private Category category;
    private Integer pages;
    private String coverImageUrl;
    private String summary;
    private LocalDate publishedDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private BookStatus bookStatus;

    public BookDTO() {
        super();
    }

    public BookDTO(Long id, LocalDateTime createdAt, LocalDateTime updatedAt,
                   String bookName, Author author, Category category, Integer pages,
                   String coverImageUrl, String summary, LocalDate publishedDate,
                   LocalDate returnDate, LocalDate dueDate, BookStatus bookStatus) {
        super(id, createdAt, updatedAt);
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.coverImageUrl = coverImageUrl;
        this.summary = summary;
        this.publishedDate = publishedDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.bookStatus = bookStatus;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
