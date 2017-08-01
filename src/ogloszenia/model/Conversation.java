package ogloszenia.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conversation {

	@Id
	@Column(name="id", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false)
	private Advertisement advertisement;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private User messageSender;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	User messageReceiver;
	
	@OneToMany(mappedBy="conversation")
	Set<ConversationMessage> conversationMessages;
	
	public Conversation() {
		super();
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public User getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(User messageSender) {
		this.messageSender = messageSender;
	}

	public User getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(User messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	

	public LocalDate getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDate messageDate) {
		this.messageDate = messageDate;
	}

	@Column(nullable=false)
	private LocalDate messageDate;

	
	
	
	
	
}