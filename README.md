# ebay-java-sdk
>**Version 1131**

This is a clone of the official [eBay Java SDK](https://developer.ebay.com/tools/javasdk), but structured as a Maven project for easy installation and use in Java applications. The SDK provides a simple Java API for calling eBay's [Trading API](https://developer.ebay.com/Devzone/XML/docs/Reference/ebay/index.html).

Javadocs for the latest official distribution of the SDK can be found [here](https://developer.ebay.com/DevZone/Javasdk-jaxb/docs/LibRef/index.html).

The release notes for version 1131 of the Trading API can be found [here](https://developer.ebay.com/DevZone/XML/docs/ReleaseNotes.html#1131)

## Usage
>Note: You need an [eBay Developer Account](https://developer.ebay.com/) to use this SDK.

You must build and install the eBay Java SDK before including it as a dependency in your application. Included in this repository is the [Maven Wrapper](https://github.com/takari/maven-wrapper) which you can use if you don't have Maven already installed.

### Building and Installing the eBay Java SDK

> It's recommended to compile this with [JDK 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html), although JDK 7 will probably work too.

1. Clone this repository:
    ```bash
    git clone https://github.com/ethanrubinson/ebay-java-sdk
    ```

2. Navigate to the project root:
    ```bash
    cd ebay-java-sdk/
    ```

3. Use Maven, or the Maven Wrapper to build and install the SDK:
    ```bash
    # Use an existing Maven installation
    mvn clean install
    
    # Use the Maven Wrapper on Unix
    ./mvnw clean install
    
    # Use the Maven Wrapper for Batch
    ./mvnw.cmd clean install
    ```

4. Check your console for successful build and installation logs. It should look similar to this:
    ```
    [INFO] Installing .../ebay-java-sdk/target/ebaysdkcore-1131.jar to .../ebaysdkcore/ebaysdkcore/1131/ebaysdkcore-1131.jar
    [INFO] Installing .../ebay-java-sdk/pom.xml to .../ebaysdkcore/ebaysdkcore/1131/ebaysdkcore-1131.pom
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  ...
    [INFO] Finished at: ...
    [INFO] ------------------------------------------------------------------------
    ```

Congratulations! The eBay Java SDK is now installed in your local repository and ready to be included in your projects.

### Including the Installed eBay Java SDK in Maven Projects

To include the now-installed SDK in your Maven project, simply add the following dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>ebaysdkcore</groupId>
  <artifactId>ebaysdkcore</artifactId>
  <version>1131</version>
</dependency>
```

### Including the Installed eBay Java SDK in Java Projects

The eBay Java SDK can also be included in regular Java Projects by configuring your build path.

#### Option 1) Add the SDK as a project dependency

In Eclipse (or your desired IDE), Go to `File > Import...`  and select ` Maven > Existing Maven Projects` as the import source. Browse to the root of the `ebay-java-sdk` folder and import the project.

Next, in your project, look for a setting called `Configure Build Path...` or `Java Build Path`. Add the `ebaysdkcore` project under the 'Projects' tab in the build path settings.

#### Option 2) Add the SDK JAR as a library dependency

Look for a setting called `Configure Build Path...` or `Java Build Path`. Under the 'Libraries' tab in the build path settings click `Add External JARs`.

Add the `ebaysdkcore-1131.jar` which was installed to your Maven local repository. The location of this JAR can be found in the build output above:

`[INFO] Installing .../ebay-java-sdk/target/ebaysdkcore-1131.jar to ...`

### Making an API Call

The following code shows the bare minimum implementation needed to call eBay's Trading API. It gets the current eBay time on the US site and prints it out to the console.

```java
import java.util.Calendar;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.helper.ConsoleUtil;

public class ApplicationHelloWorld {

  public static void main(String[] args) {
    try {
      /*
       * Step 1) Instantiate a new instance of ApiContext
       */
      ApiContext apiContext = new ApiContext();

      /*
       * Step 2) Get the ApiCredential instance from the ApiContext you just created.
       */
      ApiCredential cred = apiContext.getApiCredential();

      /* 
       * Step 3) Configure ONE of the following authentication strategies:
       * 
       * a) Use an OAuth user-token. This token can be minted from the ebay-oauth-java-client. [RECOMMENDED]
       * --> cred.setOAuthToken(oAuthToken);
       * 
       * b) Use an eBay (Auth'n'Auth) user-token. [NOT RECOMMENDED]
       * --> cred.seteBayToken(oAuthToken);
       * 
       * c) Use your eBay Developer Account and eBay Account credentials directly. [NOT RECOMMENDED]
       * --> cred.setApiAccount(apiAccount);
       * --> cred.seteBayAccount(ebayAccount);
       */
      String oAuthUserToken = ConsoleUtil.readString("Enter your eBay Authentication Token: ");
      cred.setOAuthToken(oAuthUserToken);

      /*
       * Step 4) Set API server URL for the environment you'll be calling.
       * 
       *  Production --> https://api.ebay.com/wsapi
       *  Sandbox    --> https://api.sandbox.ebay.com/wsapi
       */
      String apiUrl = ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi): ");
      apiContext.setApiServerUrl(apiUrl);

      /*
       * Step 5) Create a call object with the ApiContext instance you've configured and execute it.
       */
      GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
      Calendar cal = apiCall.geteBayOfficialTime();

      System.out.println("Official eBay Time : " + cal.getTime().toString());
    } catch (Exception e) {
      System.out.println("Failed to get the eBay official time.");
      e.printStackTrace();
    }

  }

}
```
