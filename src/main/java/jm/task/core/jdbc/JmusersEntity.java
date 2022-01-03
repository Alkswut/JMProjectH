package jm.task.core.jdbc;

import javax.persistence.*;

@Entity
//@Table(name = "jmusers") //, schema = "mydbtest", catalog = ""
public class JmusersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private long id;
    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "LastName", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "Age", nullable = false)
    private byte age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
