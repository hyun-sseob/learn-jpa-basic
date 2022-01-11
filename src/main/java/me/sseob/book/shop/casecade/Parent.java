package me.sseob.book.shop.casecade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

	@Id
	@GeneratedValue
	@Column(name = "parent_id")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> childList = new ArrayList<>();
	
	public Parent(String name) {
		this.name = name;
	}

	public Parent() {
		
	}
	
	// 연관관계 편의 method
	public void addChild(Child child) {
		childList.add(child);
		child.setParent(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChildList() {
		return childList;
	}

	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}
}