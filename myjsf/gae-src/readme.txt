1. In catalogul lib se copiaza resursele din apache-myfaces
Varianta originala javax-faces-2.3.2 genereaza eroara in executie.

2. Fisierul appengine-web.xml se completeaza cu 

   <sessions-enabled>true</sessions-enabled>

3. Se completeaza cataloagele src si war.

4. Se completeaza fisierul build.xml cu
  <target name="compile"
    . . .
    <javac
      <classpath
        . . .
(i)     <fileset dir="lib">
          <include name="*.jar"/>
        </fileset> 
      </classpath>
      . . .
    </javac>
    <copy
      . . .
(ii)  <fileset dir="lib">
        <include name="*.jar" />
      </fileset>
    </copy>  
(iii)
     <copy todir="war/WEB-INF/classes/appjud" file="src/judete.txt"/>
     

Se va apela http://localhost:8080