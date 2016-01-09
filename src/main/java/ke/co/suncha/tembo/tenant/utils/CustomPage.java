package ke.co.suncha.tembo.tenant.utils;


/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 *
 */
public class CustomPage {
	private boolean first;
	private boolean last;
	private int totalPages;
	private Long totalElements;
	private int numberOfElements;
	private Object content;
	/**
	 * @return the first
	 */
	public boolean isFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(boolean first) {
		this.first = first;
	}
	/**
	 * @return the last
	 */
	public boolean isLast() {
		return last;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(boolean last) {
		this.last = last;
	}
	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return the totalElements
	 */
	public Long getTotalElements() {
		return totalElements;
	}
	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	/**
	 * @return the numberOfElements
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}
	/**
	 * @param numberOfElements the numberOfElements to set
	 */
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	/**
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Object content) {
		this.content = content;
	}	
}
