package io.book.library.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "User_Cpf")
    @CPF
    private String CPF;
    @Column(name = "User_Address")
    private String userAddress;
    @Column(name = "User_Email")
    private String userEmail;
    @ManyToOne
    @JoinColumn(name = "Book_ID")
    private Book Book;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public User()
    {

    }

    public User(Long userID, String userName, String CPF, String userAddress, Book book, LocalDateTime createdAt) {
        UserID = userID;
        this.userName = userName;
        this.CPF = CPF;
        this.userAddress = userAddress;
        this.Book = book;
        this.createdAt = createdAt;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Book getBook() {
        return Book;
    }

    public void setBook(Book book) {
        Book = book;
    }
}
