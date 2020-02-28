# ebay-java-sdk
>**Version 1131**

This is a clone of the official eBay Java SDK distribution, but structured as a Maven project for easy installation and use in Java applications. The SDK provides a simple Java API for calling eBay's [Trading API](https://developer.ebay.com/Devzone/XML/docs/Reference/ebay/index.html).

Javadocs for the latest official distribution of the SDK can be found [here](https://developer.ebay.com/DevZone/Javasdk-jaxb/docs/LibRef/index.html).

The release notes for version 1131 of the Trading API can be found [here](https://developer.ebay.com/DevZone/XML/docs/ReleaseNotes.html#1131)

## Usage
>Note: You need an [eBay Developer Account](https://developer.ebay.com/) to use this SDK.

You must build and install the eBay Java SDK before including it as a dependency in your application. Included in this repository is the [Maven Wrapper](https://github.com/takari/maven-wrapper) which you can use if you don't have Maven already installed.

### Building and Installing the eBay Java SDK

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
