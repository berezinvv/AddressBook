package com.addressbook.entity;


import javax.persistence.*;

@Entity
@Table(name = "WorkPlace")
public class WorkPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "Id")
    private Employee employee;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false, referencedColumnName = "Id")
    private Company company;

    @Column(name = "position")
    private Position position;

    public WorkPlace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "WorkPlace{" +
                "id=" + id +
                ", employee_id=" + employee +
                ", company_id=" + company +
                ", position='" + position + "'" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkPlace)) return false;

        WorkPlace workPlace = (WorkPlace) o;

        if (id != workPlace.id) return false;
        if (getEmployee() != null ? !getEmployee().equals(workPlace.getEmployee()) : workPlace.getEmployee() != null)
            return false;
        if (getCompany() != null ? !getCompany().equals(workPlace.getCompany()) : workPlace.getCompany() != null)
            return false;
        return getPosition() == workPlace.getPosition();
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        result = 31 * result + (getCompany() != null ? getCompany().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }
}
