package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "table_departments")

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "introduced_at")
    private String introduced;

        public Department() { super(); }

        public long getId() { return id; }
        public void setId(long id) { this.id = id; }

        public String getDepartmentName() { return departmentName; }
        public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

        public String getIntroduced() { return introduced; }
        public void setIntroduced(String introduced) { this.introduced = introduced; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

        public Company getCompany() { return company; }
        public void setCompany(Company company) { this.company = company; }

}

