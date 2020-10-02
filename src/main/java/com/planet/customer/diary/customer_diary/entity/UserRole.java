package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER_ROLE")
public class UserRole extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6094612306372604302L;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "ACTIVE")
	private Boolean active;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserRoleMap> userRoleMaps;

	public UserRole(final Long id, final String name, final String description, final Integer priority,
			final Boolean active) {
		super(id);
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.active = active;
	}

	public UserRole() {
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(final Integer priority) {
		this.priority = priority;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}

	public Boolean isActive() {
		return Boolean.TRUE.equals(this.active);
	}

	public List<UserRoleMap> getUserRoleMaps() {
		return userRoleMaps;
	}

	public void setUserRoleMaps(final List<UserRoleMap> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return super.equals(obj);
	}

}
