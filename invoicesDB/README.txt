In order to compile it you need to add external jar (jdbf-1.2.jar) to your maven repository.
GO to a folder where jar file is located and write in a console:


    mvn install:install-file -Dfile=jdbf-1.2.jar -DgroupId=com.hexiong \
        -DartifactId=jdbf -Dversion=0.1 -Dpackaging=jar
