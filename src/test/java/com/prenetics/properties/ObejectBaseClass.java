package com.prenetics.properties;

import static com.prenetics.swagger.testing.invoker.GsonObjectMapper.gson;
import static com.prenetics.swagger.testing.invoker.ResponseSpecBuilders.shouldBeCode;
import static com.prenetics.swagger.testing.invoker.ResponseSpecBuilders.validatedWith;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import java.lang.reflect.Method;
import java.sql.SQLException;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import com.prenetics.common.utility.DataBaseConnector;
import com.prenetics.common.utility.ReadPropertiesFile;
import com.prenetics.common.utility.Utilities;
import com.prenetics.properties.RestAssuredBaseClass;
import com.prenetics.swagger.testing.invoker.ApiClient;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;

public class ObejectBaseClass extends RestAssuredBaseClass {
	protected static final Utilities UTILS = new Utilities();
	protected final ReadPropertiesFile config = new ReadPropertiesFile();
	protected static final ProductInfo INFO = new ProductInfo() {

		@Override
		public String getRegisterRequestBody(String barcode, String email, String password) {
			return null;
		}

		@Override
		public String getBarcodeProvider() {
			return "aviva-hk";
		}

		@Override
		public String getProduct() {
			return "circle-1";
		}

		@Override
		public String getLoginRequestBody(String email, String password) {
			return null;
		}

		@Override
		public String getLoginEndpoint() {
			return null;
		}

		@Override
		public String getRegisterRequestBody(String email, String password) {
			return null;
		}

		@Override
		public String getRegisterEndpoint() {
			return null;
		}

		@Override
		public String getTrackKitEndPoint() {
			return null;
		}
	};

	@BeforeMethod
	public void setup(Method method) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = config.testBaseUrl();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		test = extent.createTest(method.getName());
	}

	protected Utilities getUtils() {
		return UTILS;
	}

	@Override
	protected ProductInfo getInfo() {
		return INFO;
	}

	public ApiClient initializeCircleClient() {
		ApiClient client = ApiClient.api(ApiClient.Config.apiConfig()
				.reqSpecSupplier(() -> new RequestSpecBuilder()
						.setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
						.addFilter(new ErrorLoggingFilter())));
		return client;
	}

	public void registerSampleIntoLab(String barcode) {
		ApiClient client = initializeCircleClient();
		client.workflow().createSample().barcodePath(barcode)
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_CREATED).expectContentType(ContentType.JSON)));
	}

	public String getCustomerIDQuery(String query, String connectionURL) throws ClassNotFoundException, SQLException {
		return DataBaseConnector.executeSQLQuery(query, connectionURL);
	}

	public String getCustomerIDQuery() {
		String email = getUtils().getValue("email");
		String customerID = "select customer_id from customer where account='" + email + "';";
		return customerID;
	}

	public String getCustomerID() throws ClassNotFoundException, SQLException {
		String query = getCustomerIDQuery();
		return getCustomerIDQuery(query, UTILS.getProps().testIdentityServerURL());
	}

	public String extractionPrepQuery(String productCode, String customerID)
			throws ClassNotFoundException, SQLException {
		String extractionPrepQuery = "INSERT INTO tbl_log(\"type\",\"params\",\"msg\")\n" + "VALUES\n"
				+ "('INFO','{\"status\": \"sample-processing\", \"product_id\": " + productCode + ", \"customer_id\": "
				+ customerID + "}','Calculated from extraction prep complete as of  -11-13');";
		return extractionPrepQuery;
	}

	public String reportCompleteQuery(String productCode, String customerID)
			throws ClassNotFoundException, SQLException {
		String reportCompleteQuery = "INSERT INTO tbl_log (type,params,msg) VALUES ('INFO','{\"host\": \"5468081e6779\", \"task\": \"controller\", \"status\": \"report-complete\", \"workflow\": \"mydnapro\", \"product_id\": "
				+ productCode + ", \"customer_id\": " + customerID
				+ ", \"controller_msgid\": \"b7368193-76e7-49a4-9efe-d1c7569631a4\"}','myDNA Pro report complete');";
		return reportCompleteQuery;
	}

	public String generateReportQuery(String productCode, String customerID)
			throws ClassNotFoundException, SQLException {
		String generateReportQuerry = "INSERT INTO tbl_log (type,params,msg) VALUES ('INFO','{\"host\": \"36c52d67835b\", \"task\": \"controller\", \"action\": [\"generate-report\"], \"notify\": 1, \"status\": \"report-generated\", \"user_id\": 1, \"workflow\": \"mydnapro\", \"product_id\": "
				+ productCode + ", \"customer_id\": " + customerID
				+ ", \"controller_msgid\": \"bb068035-b848-4594-a17a-7b5705c888cf\"}','Status \"report-generated\" triggered');";
		return generateReportQuerry;
	}

}
