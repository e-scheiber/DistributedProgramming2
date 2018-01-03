#!/bin/bash
GroupID=action
ArtifactID=mystruts2annotation
Version=1.0
ArchetypeVersion=2.5.5
mvn archetype:generate -B -DgroupId=$GroupID -DartifactId=$ArtifactID -Dversion=$Version -DarchetypeGroupId=org.apache.struts -DarchetypeArtifactId=struts2-archetype-convention -DarchetypeVersion=$ArchetypeVersion -DremoteRepositories=http://struts.apache.org
