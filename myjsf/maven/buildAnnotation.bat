set GroupID=myjsf
set ArtifactID=myjsfAnnotation
set Version=1.0
mvn -B archetype:generate -DgroupId=%GroupID% -DartifactId=%ArtifactID% -Dversion=%Version% -DarchetypeArtifactId=maven-archetype-webapp
