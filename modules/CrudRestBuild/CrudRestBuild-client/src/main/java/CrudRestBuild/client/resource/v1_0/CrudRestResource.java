package CrudRestBuild.client.resource.v1_0;

import CrudRestBuild.client.dto.v1_0.CrudRest;
import CrudRestBuild.client.http.HttpInvoker;
import CrudRestBuild.client.pagination.Page;
import CrudRestBuild.client.problem.Problem;
import CrudRestBuild.client.serdes.v1_0.CrudRestSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author DELL
 * @generated
 */
@Generated("")
public interface CrudRestResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<CrudRest> getCrudPage(Long crudId) throws Exception;

	public HttpInvoker.HttpResponse getCrudPageHttpResponse(Long crudId)
		throws Exception;

	public Page<CrudRest> putCrudCrudUpdatePage(Long crudId, CrudRest crudRest)
		throws Exception;

	public HttpInvoker.HttpResponse putCrudCrudUpdatePageHttpResponse(
			Long crudId, CrudRest crudRest)
		throws Exception;

	public Page<CrudRest> postCrudAddPage(CrudRest crudRest) throws Exception;

	public HttpInvoker.HttpResponse postCrudAddPageHttpResponse(
			CrudRest crudRest)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public CrudRestResource build() {
			return new CrudRestResourceImpl(this);
		}

		public Builder contextPath(String contextPath) {
			_contextPath = contextPath;

			return this;
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		public Builder parameters(String... parameters) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				_parameters.put(parameterName, parameterValue);
			}

			return this;
		}

		private Builder() {
		}

		private String _contextPath = "";
		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class CrudRestResourceImpl implements CrudRestResource {

		public Page<CrudRest> getCrudPage(Long crudId) throws Exception {
			HttpInvoker.HttpResponse httpResponse = getCrudPageHttpResponse(
				crudId);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, CrudRestSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getCrudPageHttpResponse(Long crudId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + _builder._contextPath +
						"/o/CrudRestBuild/v1.0/{crudId}/cruds");

			httpInvoker.path("crudId", crudId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<CrudRest> putCrudCrudUpdatePage(
				Long crudId, CrudRest crudRest)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				putCrudCrudUpdatePageHttpResponse(crudId, crudRest);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, CrudRestSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse putCrudCrudUpdatePageHttpResponse(
				Long crudId, CrudRest crudRest)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(crudRest.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + _builder._contextPath +
						"/o/CrudRestBuild/v1.0/{crudId}/cruds/update");

			httpInvoker.path("crudId", crudId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<CrudRest> postCrudAddPage(CrudRest crudRest)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = postCrudAddPageHttpResponse(
				crudRest);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, CrudRestSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse postCrudAddPageHttpResponse(
				CrudRest crudRest)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(crudRest.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + _builder._contextPath +
						"/o/CrudRestBuild/v1.0/cruds/Add");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private CrudRestResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			CrudRestResource.class.getName());

		private Builder _builder;

	}

}