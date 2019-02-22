package eu.eurogestion.ese.blockchain;

import lombok.Data;

/**
 * @author Rmerino
 *
 */

@Data
public class Course {

	private String courseId;
	
	private String reference;
	
	private String center;
	
	private String creationDate;
	
	private String creationHash;
	
	private String planningDate;
	
	private String planningHash;
	
	private String requestDate;
	
	private String requestHash;
	
	private String receiveDate;
	
	private String receiveHash;
	
	private String grantDate;
	
	private String grantHash;
	
	private String refuseDate;
	
	private String refuseHash;
	
	private String startDate;
	
	private String startHash;
	
	private String passDate;
	
	private String passHash;
	
	private String failDate;
	
	private String failHash;
	
	private String notificationDate;
	
	private String notificationHash;
	
	private String rejectDate;
	
	private String rejectHash;
	
	private String expirationDate;
	
	private String expirationHash;
	
	private String renewalDate;
	
	private String titleId;
	
	private String status;
}
