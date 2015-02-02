package com.webcontext.apps.webmongo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * An entity representing a video game entry.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
public class Game {

	private Long _id;

	/*--- Game title---*/
	private String title;

	/*--- identification ---*/
	private String barcode;

	/*--- Platforms ---*/
	private String platforms;
	private String platform;

	/*--- Description ---*/
	private String cover;
	private String header;
	private String content;

	/*--- Studio and edition details  ---*/
	private Date publishedAt;
	private String studio;
	private String editor;
	private String publisher;

	/*--- Tags ---*/
	private String tags;

	/*--- Rates  ---*/
	private Integer rate;

	private String rated;

	private String rates;

	/*--- Minus vs. plus ---*/
	private String plus;
	private String minus;

	/*--- Entry user creator details ---*/
	private Date createdAt;
	private String createdBy;

	/**
	 * @return the id
	 */
	public Long getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this._id = id;
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
	 * @param tags
	 *            the tags to set
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
	 * @param rate
	 *            the rate to set
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
	 * @param rated
	 *            the rated to set
	 */
	public void setRated(String rated) {
		this.rated = rated;
	}

	/**
	 * @return the rates
	 */
	public Map<String, String> getRates(String rateName) {
		Map<String, String> ratesMap = new HashMap<>();
		Gson gson = new Gson();
		ratesMap = (Map<String, String>) gson.fromJson(rates, Map.class);
		return ratesMap;
	}

	/**
	 * @param rates
	 *            the rates to set
	 */
	public void setRates(String rates) {
		this.rates = rates;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * @param editor
	 *            the editor to set
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * @return the plus
	 */
	public String[] getPlus() {
		return plus.split(",");
	}

	/**
	 * @param plus
	 *            the plus to set
	 */
	public void setPlus(String plus) {
		this.plus = plus;
	}

	/**
	 * @return the minus
	 */
	public String[] getMinus() {
		return minus.split(",");
	}

	/**
	 * @param minus
	 *            the minus to set
	 */
	public void setMinus(String minus) {
		this.minus = minus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [");
		if (_id != null)
			builder.append("_id=").append(_id).append(", ");
		if (title != null)
			builder.append("title=").append(title).append(", ");
		if (barcode != null)
			builder.append("barcode=").append(barcode).append(", ");
		if (platforms != null)
			builder.append("platforms=").append(platforms).append(", ");
		if (platform != null)
			builder.append("platform=").append(platform).append(", ");
		if (cover != null)
			builder.append("cover=").append(cover).append(", ");
		if (header != null)
			builder.append("header=").append(header).append(", ");
		if (content != null)
			builder.append("content=").append(content).append(", ");
		if (publishedAt != null)
			builder.append("publishedAt=").append(publishedAt).append(", ");
		if (studio != null)
			builder.append("studio=").append(studio).append(", ");
		if (editor != null)
			builder.append("editor=").append(editor).append(", ");
		if (publisher != null)
			builder.append("publisher=").append(publisher).append(", ");
		if (tags != null)
			builder.append("tags=").append(tags).append(", ");
		if (rate != null)
			builder.append("rate=").append(rate).append(", ");
		if (rated != null)
			builder.append("rated=").append(rated).append(", ");
		if (rates != null)
			builder.append("rates=").append(rates).append(", ");
		if (plus != null)
			builder.append("plus=").append(plus).append(", ");
		if (minus != null)
			builder.append("minus=").append(minus).append(", ");
		if (createdAt != null)
			builder.append("createdAt=").append(createdAt).append(", ");
		if (createdBy != null)
			builder.append("createdBy=").append(createdBy);
		builder.append("]");
		return builder.toString();
	}

}
