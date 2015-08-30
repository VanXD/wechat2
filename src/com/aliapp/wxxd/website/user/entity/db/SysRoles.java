package com.aliapp.wxxd.website.user.entity.db;

public class SysRoles {
    private Long id;

    private String role;

    private String description;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

	@Override
	public String toString() {
		return "SysRoles [id=" + id + ", role=" + role + ", description="
				+ description + ", available=" + available + "]";
	}
}