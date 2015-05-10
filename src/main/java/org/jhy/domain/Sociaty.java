package org.jhy.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "sociaty")
@Entity
public class Sociaty extends BaseEntity{

	private static final long serialVersionUID = -4193999867762964336L;
	
	public Sociaty() {
	}
	
	@Column(name = "disabled")
	private boolean disabled = false;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "sociaty",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<GamerInfo> gamerInfos = new HashSet<GamerInfo>();
	
	
	
	public static boolean isNameExist(String name) {
		return !findByHQL("FROM Sociaty s WHERE s.name = ?", name).isEmpty();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<GamerInfo> getGamerInfos() {
		return gamerInfos;
	}

	public void setGamerInfos(Set<GamerInfo> gamerInfos) {
		this.gamerInfos = gamerInfos;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}
