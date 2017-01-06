package br.com.hyperclass.proxypattern.usecabeca.protecao;

public interface PersonBean {
	
	public String getName();
	public String getGender();
	public String getInterests();
	public int getHotOrNotRating();
	
	public void setName(final String name);
	public void setGender(final String gender);
	public void setInterests(final String interests);
	public void setHotOrNotRating(final int rating);
}
