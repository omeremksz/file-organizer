package kalemyazilim.fileapp.fileorganizer.model;

import javax.persistence.*;

@Entity//For hibernate.
@Table(name = "user_table")//For table in DB.
public class UserModel {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "userId")
    private Long Id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPassword")
    private String userPassword;

    public UserModel() {
    }

    public UserModel(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (Id != null ? !Id.equals(userModel.Id) : userModel.Id != null) return false;
        if (userName != null ? !userName.equals(userModel.userName) : userModel.userName != null) return false;
        return userPassword != null ? userPassword.equals(userModel.userPassword) : userModel.userPassword == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
