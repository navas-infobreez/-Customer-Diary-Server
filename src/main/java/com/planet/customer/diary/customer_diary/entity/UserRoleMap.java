package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBL_USER_ROLE_MAP", 
uniqueConstraints = @UniqueConstraint(name = "unique_map_usert_Role", columnNames = {"USER_ID","USER_ROLE_ID"}))
public class UserRoleMap extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6218925434804285435L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ROLE_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserRole userRole;

	public UserRoleMap(final UserRole userRole) {
		this.userRole = userRole;
	}

	public UserRoleMap() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(final UserRole userRole) {
		this.userRole = userRole;
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
