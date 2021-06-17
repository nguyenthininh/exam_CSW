package com.example.ninh.exam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "t1904e_examcsw", catalog = "")
public class EmployeeEntity {
    private Integer id;
    private String name;
    private Integer salary;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "salary", nullable = true, length = -1)
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(salary, that.salary) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }


}
