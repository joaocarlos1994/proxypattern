package br.com.hyperclass.proxypattern.usecabeca.protecao;

public class PersonBeanImpl implements PersonBean {
	
	private String name;
	private String gender;
	private String interests;
	private int rating;
	
	private int ratingCount = 0;
	
	public PersonBeanImpl(final String name, final String gender, 
						  final String interests, final int rating) {
		super();
		this.name = name;
		this.gender = gender;
		this.interests = interests;
		this.rating = rating;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getInterests() {
		return interests;
	}

	@Override
	public int getHotOrNotRating() {
		if (ratingCount == 0) 
			return 0;
		return (rating/ratingCount);
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public void setGender(final String gender) {
		this.gender = gender;
	}

	@Override
	public void setInterests(final String interests) {
		this.interests = interests;
	}

	@Override
	public void setHotOrNotRating(int rating) {
		this.rating += rating;
		ratingCount++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonBeanImpl other = (PersonBeanImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
