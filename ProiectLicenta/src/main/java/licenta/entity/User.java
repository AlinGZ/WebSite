package licenta.entity;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,unique = true, nullable = false)
    private int id;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "loaned_sum", nullable = false)
    private double loaned_sum;
    
    @Column(name = "period", nullable = false)
    private int period;

    @Column(name = "interest_rate", nullable = false)
    private double interest_rate;
    
    @Column(name = "DAE", nullable = true)
    private double DAE;
    
    @Column(name = "monthly_payment", nullable = true)
    private double monthly_payment;
    
    @Column(name = "total_amount", nullable = true)
    private double total_amount;
    
    @Column(name = "score", nullable = true)
    private int score;
    
    @Column(name = "eligibility", nullable = true)
    private String eligibility;
    
    public User() {}

    public User(String lastName, String firstName, String gender, int age, double salary, double loaned_sum, int period, double interest_rate, double DAE, double monthly_payment, double total_amount, int score, String eligibility) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.loaned_sum = loaned_sum;
        this.period = period;
        this.interest_rate = interest_rate;
        this.DAE = DAE;
        this.monthly_payment = monthly_payment;
        this.total_amount = total_amount;
        this.score = score;
        this.eligibility = eligibility;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getLoaned_sum() {
        return loaned_sum;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public double getDAE() {
        return DAE;
    }

    public String getEligibility() {
        return eligibility;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getMonthly_payment() {
        return monthly_payment;
    }

    public void setMonthly_payment(double monthly_payment) {
        this.monthly_payment = monthly_payment;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
