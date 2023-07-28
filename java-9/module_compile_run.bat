javac -d target/classes \
 src/main/java/com/java/nine/modules/recommendation/MovieRecommendationController.java \
 src/main/java/com/java/nine/modules/App.java \
 src/main/java/module-info.java

jar -c -f target/movie_fe.jar --main-class com.java.nine.modules.App \
 -C target/classes/ .

rm -fr "target/classes" /S /Q

java -p target --module com.java.nine.modules