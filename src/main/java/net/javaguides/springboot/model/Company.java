package net.javaguides.springboot.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "table_companys")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "compnay_name")
    private String companyName;

        public Company() { super(); }

        public long getId() { return id; }
        public void setId(long id) { this.id = id; }

        public String getCompanyName() { return companyName; }
        public void setCompanyName(String companyName) { this.companyName = companyName; }


    @OneToMany(mappedBy = "company")
    private Set<Department> department = new HashSet<>();

        public Set<Department> getDepartment() {
            return department;
        }

        public void setDepartment(Set<Department> department) {
            this.department = department;
        }
}
