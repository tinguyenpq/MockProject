package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the r_f_o_user database table.
 * 
 */
@Entity
@Table(name="r_f_o_user")
@NamedQuery(name="RFOUser.findAll", query="SELECT r FROM RFOUser r")
public class RFOUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String email;
	private boolean enabled;
	private String firstName;
	private String lastName;
	private String password;
	private String title;
	private String username;
	private List<Agreement> agreements;
	private UserType userType;

	public RFOUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id", unique=true, nullable=false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Column(nullable=false, length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(nullable=false)
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Column(name="first_name", length=45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="last_name", length=45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(nullable=false, length=45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(length=45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Column(nullable=false, length=45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	//bi-directional many-to-one association to Agreement
	@OneToMany(mappedBy="RFOUser")
	public List<Agreement> getAgreements() {
		return this.agreements;
	}

	public void setAgreements(List<Agreement> agreements) {
		this.agreements = agreements;
	}

	public Agreement addAgreement(Agreement agreement) {
		getAgreements().add(agreement);
		agreement.setRFOUser(this);

		return agreement;
	}

	public Agreement removeAgreement(Agreement agreement) {
		getAgreements().remove(agreement);
		agreement.setRFOUser(null);

		return agreement;
	}


	//bi-directional many-to-one association to UserType
	@ManyToOne
	@JoinColumn(name="user_type_id")
	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}