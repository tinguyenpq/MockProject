package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_type database table.
 * 
 */
@Entity
@Table(name="user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userTypeId;
	private String userTypeName;
	private List<RFOUser> RFOUsers;

	public UserType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_type_id", unique=true, nullable=false)
	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}


	@Column(name="user_type_name", nullable=false, length=45)
	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}


	//bi-directional many-to-one association to RFOUser
	@OneToMany(mappedBy="userType")
	public List<RFOUser> getRFOUsers() {
		return this.RFOUsers;
	}

	public void setRFOUsers(List<RFOUser> RFOUsers) {
		this.RFOUsers = RFOUsers;
	}

	public RFOUser addRFOUser(RFOUser RFOUser) {
		getRFOUsers().add(RFOUser);
		RFOUser.setUserType(this);

		return RFOUser;
	}

	public RFOUser removeRFOUser(RFOUser RFOUser) {
		getRFOUsers().remove(RFOUser);
		RFOUser.setUserType(null);

		return RFOUser;
	}

}