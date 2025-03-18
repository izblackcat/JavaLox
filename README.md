# JavaLox


## Usage 

In order to use this thing here, follow the steps below :

1. Build and package the `jar` file using: 
    ```bash
   mvn clean package -DskipTests
    ```

2. After running this command the jar file will be generated in the `target` directory :
    ```bash
    java -classpath target/jLox.jar dev.izarkaoui.lox.Lox path/to/your/source.lox
    ```

3. In order not to type this whole line, you can create an alias : 
   ```bash 
   alias jlox="java -classpath target/jLox.jar dev.izarkaoui.lox.Lox path/to/your/source.lox"
   ```
