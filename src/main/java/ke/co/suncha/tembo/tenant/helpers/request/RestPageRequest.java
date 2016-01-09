package ke.co.suncha.tembo.tenant.helpers.request;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 *
 */
@Component
@Scope("prototype")
public class RestPageRequest {
	private Integer size = 10;
	private Integer page = 0;
	private String filter = "";

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the filter
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestPageRequest [size=" + size + ", page=" + page + ", filter=" + filter + "]";
	}


}
