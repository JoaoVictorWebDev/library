package io.book.library.domain.entities;

import io.book.library.domain.enums.BookStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Loan_ID")
    private Long LoanID;

    @ManyToOne
    @JoinColumn(name = "Book_ID", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @Column(name = "Loan_Date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "Due_Date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "Return_Date")
    private LocalDate returnDate;

    @Column(name = "Returned")
    private LocalDate returned;

    @Column(name = "Fine")
    private BigDecimal fine;

    @Column(name = "Notes")
    private String notes;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @Column(name = "Created_At")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Loan() {

    }

    public Long getLoanID() {
        return LoanID;
    }

    public void setLoanID(Long loanID) {
        LoanID = loanID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturned() {
        return returned;
    }

    public void setReturned(LocalDate returned) {
        this.returned = returned;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
