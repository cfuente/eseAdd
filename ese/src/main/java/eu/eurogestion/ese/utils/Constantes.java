package eu.eurogestion.ese.utils;

/**
 * @author Rmerino
 *
 */

public class Constantes {

	public static final String FORMATO_FECHA_BLOCKCHAIN = "yyyyMMdd";
	public static final String FORMATO_FECHA_LARGO = "yyyy-MM-dd";
	public static final String FORMATO_FECHA_CORTO = "yy-MM-dd";
	
	/**	BLOCKCHAIN URLS	**/	
	public static final String URL_BASE = "http://demos2.addalia.com/RailwayChainService/";
	
	public static final String URL_STAFF = URL_BASE + "resources/staff";
	public static final String URL_STAFF_ID = URL_BASE + "resources/staff/{staffId}";
	public static final String URL_STAFF_ID_STATUS = URL_BASE + "resources/staff/{staffId}/status";
	public static final String URL_STAFF_ID_REVISIONDATES = URL_BASE + "resources/staff/{staffId}/revisiondates";
	public static final String URL_STAFF_ID_COURSE = URL_BASE + "resources/staff/{staffId}/course";
	public static final String URL_STAFF_ID_TITLE = URL_BASE + "resources/staff/{staffId}/title";
	public static final String URL_STAFF_ID_REVOKE = URL_BASE + "resources/staff/{staffId}/revoke";
	
	public static final String URL_COURSE_ID = URL_BASE + "resources/course/{staffId}/{courseId}";
	public static final String URL_COURSE_ID_STATUS = URL_BASE + "resources/course/{staffId}/{courseId}/status";
	public static final String URL_COURSE_ID_ACTION = URL_BASE + "resources/course/{staffId}/{courseId}/action";
	
	public static final String URL_TEST_ID = URL_BASE + "resources/test/{staffId}/{testId}";
	public static final String URL_TEST_ID_STATUS = URL_BASE + "resources/test/{staffId}/{testId}/status";
	public static final String URL_TEST_ID_ACTION = URL_BASE + "resources/test/{staffId}/{testId}/action";
	
	public static final String URL_TITLE_ID = URL_BASE + "resources/title/{staffId}/{titleId}";
	public static final String URL_TITLE_ID_STATUS = URL_BASE + "resources/title/{staffId}/{titleId}/status";
	public static final String URL_TITLE_ID_ACTION = URL_BASE + "resources/title/{staffId}/{titleId}/action";
	public static final String URL_TITLE_ID_COURSE = URL_BASE + "resources/title/{staffId}/{titleId}/course";
	public static final String URL_TITLE_ID_TEST = URL_BASE + "resources/title/{staffId}/{titleId}/test";
	public static final String URL_TITLE_ID_SUSPENSION = URL_BASE + "resources/title/{staffId}/{titleId}/suspension";
	
	public static final String URL_SUSPENSION_ID = URL_BASE + "resources/title/{staffId}/{suspensionId}";
	public static final String URL_SUSPENSION_ID_ACTION = URL_BASE + "resources/title/{staffId}/{suspensionId}/action";
	public static final String URL_SUSPENSION_ID_EVIDENCE = URL_BASE + "resources/title/{staffId}/{suspensionId}/evidence";
	
	public static final String URL_REVOCATION_ID = URL_BASE + "resources/title/{staffId}/{revocationId}";
	public static final String URL_REVOCATION_ID_ACTION = URL_BASE + "resources/title/{staffId}/{revocationId}/action";
	public static final String URL_REVOCATION_ID_EVIDENCE = URL_BASE + "resources/title/{staffId}/{revocationId}/evidence";
	
	/** BLOCKCHAIN PARAMS**/
	public static final String TOKEN_ID_HEADER = "token-id";
	public static final String TOKEN_ID_VALUE = "YWRtaW47YWRtaW47MjAxOTAyMjgyMzU5NTk=";
	
	public static final String STAFF_ID = "staffId";
	public static final String CATEGORY = "category";
	public static final String REVISIONDATE = "revisionDate";
	public static final String STATUS = "status";
	 
	/** BLOCKCHAIN ERRORS**/
	public static final int RESPONSE_OK = 200;
	public static final int BAD_REQUEST = 400;
	public static final int NOTVALID_AUTHENTICATION = 401;
	public static final int ID_NOTEXIST = 404;
	public static final int SERVICE_UNAVAILABLE = 503;
}
