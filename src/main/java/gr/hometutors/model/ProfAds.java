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
 * Model class for the profads entity
 * 
 * @author Dimitris
 */
@Entity
@Table(name = "profads")
@Access(value = AccessType.FIELD)
public class ProfAds {

	/*
	 * Class fields that reflect the profads entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pfid")
	private Long pfid;

	@Column(name = "information")
	private String information;

	@Column(name = "reviewcode")
	private String reviewCode;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pfid", nullable = false)
	List<Reviews> reviews = new ArrayList<>();

	private String secretCode;

	/*
	 * Accessors for the class private fields
	 */

	public Long getPfid() {
		return pfid;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public void setPfid(Long pfid) {
		this.pfid = pfid;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
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
		result = prime * result + ((information == null) ? 0 : information.hashCode());
		result = prime * result + ((pfid == null) ? 0 : pfid.hashCode());
		result = prime * result + ((reviewCode == null) ? 0 : reviewCode.hashCode());
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
		ProfAds other = (ProfAds) obj;
		if (information == null) {
			if (other.information != null)
				return false;
		} else if (!information.equals(other.information))
			return false;
		if (pfid == null) {
			if (other.pfid != null)
				return false;
		} else if (!pfid.equals(other.pfid))
			return false;
		if (reviewCode == null) {
			if (other.reviewCode != null)
				return false;
		} else if (!reviewCode.equals(other.reviewCode))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfAds [pfid=" + pfid + ", information=" + information + ", reviewCode=" + reviewCode + ", secretCode="
				+ secretCode + "]";
	}

}
