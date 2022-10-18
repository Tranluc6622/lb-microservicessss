//package com.elcom.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.sql.Timestamp;
//import java.util.Date;
//
//@Entity
//@Table(name = "borrow")
//public class Borrow implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Basic(optional = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name ="id",updatable = false,nullable = false)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_users")
//    @JsonIgnore
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "id_book")
//    @JsonIgnore
//    private Book book;
//
//    @Column(name = "borrow_date")
//    private Date borrowDate;
//
//    @Column(name = "return_date")
//    private Date returnDate;
//
//    @PrePersist
//    private void onCreate()
//    {
//        borrowDate = new Date();
//    }
//
//
//    public Borrow() {
//    }
//
//    public Borrow(Long id, User user, Book book, Date borrowDate, Date returnDate) {
//        this.id = id;
//        this.user = user;
//        this.book = book;
//        this.borrowDate = borrowDate;
//        this.returnDate = returnDate;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public Date getBorrowDate() {
//        return borrowDate;
//    }
//
//    public void setBorrowDate(Date borrowDate) {
//        this.borrowDate = borrowDate;
//    }
//
//    public Date getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(Date returnDate) {
//        this.returnDate = returnDate;
//    }
//}
