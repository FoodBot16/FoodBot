package org.foodbot.domain;

public class SearchCriteria extends Criteria {
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
		
	}
	public String getKeyword() {
		return keyword;
	}
	
	public void setkeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
