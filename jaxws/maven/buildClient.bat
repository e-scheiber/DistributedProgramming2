set GroupID=cmmdc.client
set ArtifactID=jaxws-cmmdc-client
set Version=1.0
mvn archetype:generate -B -DgroupId=%GroupID% -DartifactId=%ArtifactID% -DarchetypeArtifactId=maven-archetype-quickstart -Dversion=%Version%