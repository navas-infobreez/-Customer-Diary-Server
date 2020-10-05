package com.planet.customer.diary.customer_diary.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserContact;
import com.planet.customer.diary.customer_diary.entity.UserRole;
import com.planet.customer.diary.customer_diary.entity.UserRoleMap;

public class UserDTO extends BaseDTO {

	private String firstName;

	private String lastName;

	private String userName;
	
	private String password;

	private UserContactDTO userContact;

	public UserDTO(final Long id, final String firstName, final String lastName, final String userName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public UserDTO() {
	}

	private List<UserRoleDTO> roles;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public List<UserRoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(final List<UserRoleDTO> roles) {
		this.roles = roles;
	}

	public UserContactDTO getUserContact() {
		return userContact;
	}

	public void setUserContact(final UserContactDTO userContact) {
		this.userContact = userContact;
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

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", username=" + userName
				+ ", userContact=" + userContact + ", roles=" + roles + "]";
	}

	public void mapUserContact(final User user) {
		final UserContact userContactEntity = user.getUserContact();
		if (userContactEntity != null) {
			this.setUserContact(new UserContactDTO(userContactEntity.getId(), userContactEntity.getEmail(),
					userContactEntity.getPhoneNumber()));
		}
	}

	public void mapUserRoles(final User user) {
		final List<UserRoleDTO> tempRoles = new ArrayList<>();
		for (final UserRoleMap userRoleMap : user.getUserRoleMaps()) {
			final UserRole userRole = userRoleMap.getUserRole();
			tempRoles.add(new UserRoleDTO(userRole.getId(), userRole.getName(), userRole.getDescription(),
					userRole.getPriority(), userRole.getActive()));
		}
		this.setRoles(tempRoles);
	}
	
//	public List<UserRoleMap> getUserRoles(final User user, final List<UserRoleDTO> roles) {
//		final List<UserRoleMap> tempRoles = new ArrayList<>();
//		for (final UserRoleDTO userRoleDTO : roles) {
//			final UserRoleMap userRoleMap = new UserRoleMap();
//			userRoleMap.setUser(user);
//			userRoleMap.setUserRole(new UserRole(userRoleDTO.getId(), userRoleDTO.getName(),
//					userRoleDTO.getDescription(), userRoleDTO.getPriority(), userRoleDTO.getActive()));
//			tempRoles.add(userRoleMap);
//		}
//		return tempRoles;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
