package com.demojavadj.appweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El Nombre es Obligatorio")
    private String name;
    @NotEmpty(message = "Apellido Paterno es Obligatori")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "Apellido Materno es Obligatori")
    @Column(name = "last_name")
    private String lastName;
    private String direction;
    @Column(unique = true)
    private String dni;
    @NotEmpty(message = "El Correo es Obligatori")
    @Size(min = 7, max = 20, message = "El Correo deve ser como minimo 6 a 20 caracteres")
    @Column(unique = true, nullable = true)
    private String email;
    private String password;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user-role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")

    )
    private Collection<Role> roles;


    public Users() {
    }

    public Users(Long id, String name, String firstName, String lastName, String direction, String dni, Date createAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.direction = direction;
        this.dni = dni;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String  getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
