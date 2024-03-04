package io.progame.Student;

import io.progame.Generic.GenericEntity;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;


/**
 *
 * @author Cliente
 */
@Entity
public class Student extends GenericEntity{
    
    @Id
    @SequenceGenerator(name="seq_user", sequenceName = "seq_user", initialValue = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nameStudent;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirthday;
    @Enumerated(EnumType.STRING)
    private GenderPeople gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phoneNumberStudent;
    private String emailStudent;
 
    public Student() {
        
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public GenderPeople getGender() {
        return gender;
    }

    public void setGender(GenderPeople gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumberStudent() {
        return phoneNumberStudent;
    }

    public void setPhoneNumberStudent(String phoneNumberStudent) {
        this.phoneNumberStudent = phoneNumberStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", nameStudent=" + nameStudent + ", cpf=" + cpf + ", dateOfBirthday=" + dateOfBirthday + ", gender=" + gender + ", address=" + address + ", phoneNumberStudent=" + phoneNumberStudent + ", emailStudent=" + emailStudent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nameStudent);
        hash = 17 * hash + Objects.hashCode(this.cpf);
        hash = 17 * hash + Objects.hashCode(this.dateOfBirthday);
        hash = 17 * hash + Objects.hashCode(this.gender);
        hash = 17 * hash + Objects.hashCode(this.address);
        hash = 17 * hash + Objects.hashCode(this.phoneNumberStudent);
        hash = 17 * hash + Objects.hashCode(this.emailStudent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.nameStudent, other.nameStudent)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumberStudent, other.phoneNumberStudent)) {
            return false;
        }
        if (!Objects.equals(this.emailStudent, other.emailStudent)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirthday, other.dateOfBirthday)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return Objects.equals(this.address, other.address);
    }

    
    
    
}
