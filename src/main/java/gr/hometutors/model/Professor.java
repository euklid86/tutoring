package gr.hometutors.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Model class for the professor entity
 * 
 * @author Dimitris
 */
@Entity
@Table(name = "professor")
@Access(value = AccessType.FIELD)
public class Professor {

	/*
	 * Class fields that reflec the entity profession
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prid")
	private Long prid;

	@Column(name = "secretcode")
	private String secretCode;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "profession")
	private String profession;

	@Column(name = "location")
	private String location;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prid", nullable = false)
	List<ProfAds> profAds = new ArrayList<>();

	/*
	 * Accessors for the class private fields
	 */

	public Long getPrid() {
		return prid;
	}

	public List<ProfAds> getProfAds() {
		return profAds;
	}

	public void setProfAds(List<ProfAds> profAds) {
		this.profAds = profAds;
	}

	public void setPrid(Long prid) {
		this.prid = prid;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Professor [prid=" + prid + ", secretCode=" + secretCode + ", fname=" + fname + ", lname=" + lname
				+ ", profession=" + profession + ", location=" + location + ", email=" + email + ", phone=" + phone
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((prid == null) ? 0 : prid.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((secretCode == null) ? 0 : secretCode.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (prid == null) {
			if (other.prid != null)
				return false;
		} else if (!prid.equals(other.prid))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		if (secretCode == null) {
			if (other.secretCode != null)
				return false;
		} else if (!secretCode.equals(other.secretCode))
			return false;
		return true;
	}

}
