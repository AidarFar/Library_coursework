package com.example.factory;

import jakarta.persistence.*;

/**

 Entity class representing a user role.
 @author Farkhutdinov Aidar
 */
@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	/**

	 Default constructor.
	 */
	public Role() {
	}
	/**

	 Constructor for creating a new role with the given name.
	 @param name the name of the role
	 */
	public Role(String name) {
		super();
		this.name = name;
	}
	/**

	 Returns the ID of the role.
	 @return the ID of the role
	 */
	public Long getId() {
		return id;
	}
	/**

	 Sets the ID of the role.
	 @param id the ID of the role
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**

	 Returns the name of the role.
	 @return the name of the role
	 */
	public String getName() {
		return name;
	}
	/**

	 Sets the name of the role.
	 @param name the name of the role
	 */
	public void setName(String name) {
		this.name = name;
	}
}