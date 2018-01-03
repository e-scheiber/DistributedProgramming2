GroupID=cmmdc.server
ArtifactID=jaxws-cmmdc
Version=1.0
mvn archetype:generate -B  -DgroupId=$GroupID -DartifactId=$ArtifactID -DarchetypeArtifactId=maven-archetype-webapp -Dversion=$Version
