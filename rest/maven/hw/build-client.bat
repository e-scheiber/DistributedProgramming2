set GroupId=hw
set ArtifactId=client
set jersey-version=2.26
set Version=1.0
set ArchetypeArtifactId=maven-archetype-quickstart
mvn -B archetype:generate -DarchetypeArtifactId=%ArchetypeArtifactId% -DgroupId=%GroupId% -DartifactId=%ArtifactId% -Dversion=%Version% -DinteractiveMode=false