package com.webcontext.apps.thegame.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 * An entity representing a video game entry.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
@Entity
@XmlRootElement
@Table(name = "game", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Game {

	@Id
	@GeneratedValue
	private Long id;

	/*--- Game title---*/
	@NotEmpty
	@Size(min = 1, max = 100)
	@Column(name="title")
	private String title;

	/*--- identification ---*/
	@Size(min = 0, max = 40)
	private String barcode;

	/*--- Platforms ---*/
	@Size(min = 3, max = 100)
	private String platforms;
	@Size(min = 3, max = 10)
	private String platform;

	/*--- Description ---*/
	@Size(min = 1, max = 255)
	@URL
	private String cover;
	@Size(min = 0, max = 500)
	private String header;
	@Size(min = 1, max = 6000)
	private String content;

	/*--- Studio and edition details  ---*/
	@Temporal(TemporalType.DATE)
	private Date publishedAt;
	@Size(min = 0, max = 255)
	private String studio;
	@Size(min = 0, max = 255)
	private String editor;
	@Size(min = 0, max = 255)
	private String publisher;

	/*--- Tags ---*/
	private String tags;
	
	/*--- Rates  ---*/
	private Integer rate;

	private String rated;

	private String rates;

	/*--- Minus vs. plus ---*/
	@Size(min = 0, max = 300)
	@Column(name="bulletplus")
	private String plus;
	@Size(min = 0, max = 300)
	@Column(name="bulletminus")
	private String minus;

	/*--- Entry user creator details ---*/
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@NotNull
	@Size(min = 3, max = 25)
	private String createdBy;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the platforms
	 */
	public String[] getPlatforms() {
		return platforms.split(",");
	}

	/**
	 * @param platforms
	 *            the platforms to set
	 */
	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * @param cover
	 *            the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}

	/**
	 * @return the publishedAt
	 */
	public Date getPublishedAt() {
		return publishedAt;
	}

	/**
	 * @param publishedAt
	 *            the publishedAt to set
	 */
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the rate
	 */
	public Integer getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(Integer rate) {
		this.rate = rate;
	}

	/**
	 * @return the rated
	 */
	public String getRated() {
		return rated;
	}

	/**
	 * @param rated the rated to set
	 */
	public void setRated(String rated) {
		this.rated = rated;
	}

	/**
	 * @return the rates
	 */
	public String getRates() {
		return rates;
	}

	/**
	 * @param rates the rates to set
	 */
	public void setRates(String rates) {
		this.rates = rates;
	}

}
