package com.planet.customer.diary.customer_diary.model.dto;

public class UserRoleDTO extends BaseDTO {

	private String name;

	private String description;

	private Integer priority;

	private Boolean active;

	public UserRoleDTO(final Long id, final String name, final String description, final Integer priority,
			final Boolean active) {
		super(id);
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.active = active;
	}
	
	public UserRoleDTO() {
		
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
		return "UserRoleDTO [name=" + name + ", description=" + description + ", priority=" + priority + ", active="
				+ active + "]";
	}

}
