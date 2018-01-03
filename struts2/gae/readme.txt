1. Continutul catalogului lib-struts se copiaza in 
catalogul lib al catalogului aplicatiei.

2. Se completeaza cataloagele src si war.

3. Se completeaza fisierul build.xml cu
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
    <copy todir="${war.dir}/WEB-INF/classes" file="src/struts.xml"/>
    <copy todir="${war.dir}/WEB-INF/classes/appjud" file="src/judete.txt"/>  
  </target>