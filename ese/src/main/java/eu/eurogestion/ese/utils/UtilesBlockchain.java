package eu.eurogestion.ese.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import eu.eurogestion.ese.blockchain.RevisionDate;
import eu.eurogestion.ese.blockchain.Staff;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rmerino
 *
 */

@Slf4j
public class UtilesBlockchain {

	/**
	 * Inicializa un header para realizar las llamadas REST con el valor del
	 * token-id.
	 *
	 * @return Header inicializado
	 */
	private HttpHeaders initHeader() {

		HttpHeaders headers = new HttpHeaders();
		headers.set(Constantes.TOKEN_ID_HEADER, Constantes.TOKEN_ID_VALUE);
		headers.set("Content-Type", "application/json");

		return headers;
	}

	/** STAFF **/
	/**
	 * Genera un nuevo Staff, a partir de un mapa con la siguiente estructura:<br>
	 * staffId : id<br>
	 * category : {TrainDriver, TrainOperationStaff}<br>
	 * revisionDate : YYYYMMDD
	 * 
	 * @param in Mapa con los valores a insertar.
	 * @return Staff devuelto por la peticion en base al generado.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public Staff createStaff(Map<String, String> in) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(in, initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff> response = restTemplate.exchange(Constantes.URL_STAFF, HttpMethod.POST, entity,
				Staff.class);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().toString());
		return response.getBody();
	}

	/**
	 * Busca un Staff, a partir de un ID.
	 * 
	 * @param id Identificacion del Staff a buscar.
	 * @return Staff correspondiente al ID pasado por la entrada.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public Staff findStaff(String id) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff> response = restTemplate.exchange(Constantes.URL_STAFF_ID, HttpMethod.GET, entity,
				Staff.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().toString());
		return response.getBody();
	}

	/**
	 * Modifica un Staff, a partir de un id y un mapa con la siguiente
	 * estructura:<br>
	 * 
	 * category : {TrainDriver, TrainOperationStaff}<br>
	 * revisionDate : YYYYMMDD<br>
	 * status : {NotEnabled, Enabled, Suspended, Revoked}
	 * 
	 * @param in Mapa con los valores a insertar.
	 * @param id Identificacion del Staff a modificar.
	 * @return Staff devuelto por la peticion en base al modificado.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public Staff updateStaff(Map<String, String> in, String id) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(in, initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff> response = restTemplate.exchange(Constantes.URL_STAFF_ID, HttpMethod.PUT, entity,
				Staff.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().toString());
		return response.getBody();
	}

	/**
	 * Borra un Staff, a partir de un id.
	 * 
	 * @param id Identificador del Staff a borrar.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public void deleteStaff(String id) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff> response = restTemplate.exchange(Constantes.URL_STAFF_ID, HttpMethod.DELETE, entity,
				Staff.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}
		
		log.info("DeleteStaff ejecutado correctamente.");
	}

	/**
	 * Modifica el status de un Staff, a partir de un id y un mapa con la siguiente
	 * estructura:<br>
	 * 
	 * status : {NotEnabled, Enabled, Suspended, Revoked}
	 * 
	 * @param in Mapa con los valores a insertar.
	 * @param id Identificacion del Staff a modificar.
	 * @return Staff devuelto por la peticion en base al modificado.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public Staff updateStaffStatus(Map<String, String> in, String id) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(in, initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff> response = restTemplate.exchange(Constantes.URL_STAFF_ID_STATUS, HttpMethod.PUT, entity,
				Staff.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().toString());
		return response.getBody();
	}

	/** REVISION DATES **/
	/**
	 * Añade una fecha de revision a un staff determinado por la ID.
	 * 
	 * @param id   Identificacion del Staff al cual añadir fecha de revision.
	 * @param date Fecha de revision a añadir.
	 * @return Listado de fechas de revision del Staff al cual se ha añadido la
	 *         fecha de entrada.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public List<String> addRevisionDate(String id, String date) throws BlockChainException {

		Map<String, String> aux = new HashMap<>();
		aux.put(Constantes.REVISIONDATE, date);

		HttpEntity<?> entity = new HttpEntity<>(aux, initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RevisionDate> response = restTemplate.exchange(Constantes.URL_STAFF_ID_REVISIONDATES,
				HttpMethod.POST, entity, RevisionDate.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().getRevisionDates().toString());
		return response.getBody().getRevisionDates();
	}

	/**
	 * Busca las fechas de revision de un staff determinado por la ID.
	 * 
	 * @param id Identificacion del Staff al cual añadir fecha de revision.
	 * @return Listado de fechas de revision del Staff buscado.
	 * @exception BlockChainException Codigo de error devuelto por la peticion REST
	 *                                en caso de error.
	 */
	public List<String> findRevisionDates(String id) throws BlockChainException {

		HttpEntity<?> entity = new HttpEntity<>(initHeader());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RevisionDate> response = restTemplate.exchange(Constantes.URL_STAFF_ID_REVISIONDATES,
				HttpMethod.GET, entity, RevisionDate.class, id);

		if (response.getStatusCodeValue() != Constantes.RESPONSE_OK) {
			log.error(String.valueOf(response.getStatusCodeValue()) + " " + response.getStatusCode().getReasonPhrase());
			throw new BlockChainException(String.valueOf(response.getStatusCodeValue()));
		}

		log.info(response.getBody().getRevisionDates().toString());
		return response.getBody().getRevisionDates();
	}

}
