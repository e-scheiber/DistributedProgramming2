set GroupID=cmmdc.server
set ArtifactID=jaxws-cmmdc
set Version=1.0
mvn archetype:generate -B  -DgroupId=%GroupID% -DartifactId=%ArtifactID% -DarchetypeArtifactId=maven-archetype-webapp -Dversion=%Version%
