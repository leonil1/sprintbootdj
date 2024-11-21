package com.demojavadj.appweb.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_loan")
    private Date dateLoan;
    @Column(name = "date_return")
    private Date dateReturn;
    private Boolean status;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public Loan() {
    }

    public Loan(Long id, Date dateLoan, Date dateReturn, Boolean status, Date createAt, Date updateAt) {
        this.id = id;
        this.dateLoan = dateLoan;
        this.dateReturn = dateReturn;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
