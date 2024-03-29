package ogloszenia.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Advertisement {
	/*
	tytul
    zdjecie
    wlasciciel
    cena
    tresc
    data od
    data do
    czy aktywne
    czy premium
    city name
    ocena od osoby kupujacej
    kategoria
    liczba wyswietlen
	 */
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	Integer id;
	
	
	@Column(nullable=false)
	String title;
	
	@Lob
	byte[] img;						
	
	@JoinColumn(nullable=false)
	@ManyToOne(cascade=CascadeType.ALL)
	User owner; 

	@Column(nullable=false)
	BigDecimal price;
	
	@Column(nullable=false)
	String text;
	
	@Column(nullable=false)
	LocalDate dateFrom;
	
	@Column(nullable=false)
	LocalDate dateTo;
	
	@Column(nullable=false)
	Boolean isActive;
	
	@Column(nullable=false)
	Boolean isPremium;
	
	@Column(nullable=false)
	String cityName;
	
	@Column(nullable=false)
	Integer rating;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	CATEGORY category;
	
	@Column(nullable=false)
	Integer views;
	
	@ManyToMany
	@JoinTable(
			joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="watcher_id")
			)
	Set <User> watchers;
	
	@OneToMany(mappedBy="advertisementId")
	Set<Conversation> messages;
	
	@OneToMany(mappedBy="advertisement")
	Set<Image> images;
	
	
	public Advertisement(){}
	
	public Advertisement(String title, BigDecimal price, String description, String location, User user) {
		this.title = title;
		this.text = description;
		this.price = price;
		this.cityName = location;
		this.owner = user;
		
		this.category = CATEGORY.MOTORYZACJA;
		this.isPremium = false;
		this.isActive = true;
		this.views = 0;
		this.dateFrom = LocalDate.now();
		this.dateTo = this.dateFrom.plusMonths(1);
		this.rating = 0;
		
	}
	
	public byte[] getImg() {
		return img;
	}



	public void setImg(byte[] img) {
		this.img = img;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public CATEGORY getCategory() {
		return category;
	}

	public void setCategory(CATEGORY category) {
		this.category = category;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}

}
