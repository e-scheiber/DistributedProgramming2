package unitbv.cs.td.client;
import java.util.List;
import java.util.ArrayList;
public class DBJudete implements java.io.Serializable{
  private List<RefJudet> refJudete;
  
  public DBJudete(){
    refJudete=new ArrayList(43); 
    refJudete.add(new RefJudet("Alba AlbaIulia AB"));
    refJudete.add(new RefJudet("Arad Arad AR"));
    refJudete.add(new RefJudet("Arges Pitesti AG"));
    refJudete.add(new RefJudet("Bacau Bacau BC"));
    refJudete.add(new RefJudet("Bihor Oradea BH"));
    refJudete.add(new RefJudet("BistritaNasaud Bistrita BN"));
    refJudete.add(new RefJudet("Botosani Botosani BT"));
    refJudete.add(new RefJudet("Brasov Brasov BV"));
    refJudete.add(new RefJudet("Braila Braila BR"));
    refJudete.add(new RefJudet("Bucuresti Bucuresti B"));
    refJudete.add(new RefJudet("Buzau Buzau BZ"));
    refJudete.add(new RefJudet("Calarasi Calarasi CL"));
    refJudete.add(new RefJudet("CarasSeverin Resita CS"));
    refJudete.add(new RefJudet("Cluj ClujNapoca CJ"));
    refJudete.add(new RefJudet("Constanta Constanta CT"));
    refJudete.add(new RefJudet("Covasna SfantuGheorghe CV"));
    refJudete.add(new RefJudet("Dolj Craiova DJ"));
    refJudete.add(new RefJudet("Dambovita Targoviste TR"));
    refJudete.add(new RefJudet("Galati Galati GL"));
    refJudete.add(new RefJudet("Giurgiu Giurgiu GR"));
    refJudete.add(new RefJudet("Gorj TirguJiu GJ"));
    refJudete.add(new RefJudet("Harghita MiercureaCiuc HR"));
    refJudete.add(new RefJudet("Hunedoara Deva HD"));
    refJudete.add(new RefJudet("Ialomita Slobozia IL"));
    refJudete.add(new RefJudet("Iasi Iasi IS"));
    refJudete.add(new RefJudet("Ilfov Bucuresti IF"));
    refJudete.add(new RefJudet("Maramures BaiaMare MM"));
    refJudete.add(new RefJudet("Mehedinti DrobetaTurnuSeverin MH"));
    refJudete.add(new RefJudet("Mures TarguMures MR"));
    refJudete.add(new RefJudet("Neamt PiatraNeamt NT"));
    refJudete.add(new RefJudet("Olt Slatina OT"));
    refJudete.add(new RefJudet("Prahova Ploiesti PH"));
    refJudete.add(new RefJudet("SatuMare SatuMare SM"));
    refJudete.add(new RefJudet("Salaj Zalau SJ"));
    refJudete.add(new RefJudet("Sibiu Sibiu SB"));
    refJudete.add(new RefJudet("Suceava Suceava SV"));
    refJudete.add(new RefJudet("Teleorman Alexandria TR"));
    refJudete.add(new RefJudet("Timis Timisoara TM"));
    refJudete.add(new RefJudet("Tulcea Tulcea TL"));
    refJudete.add(new RefJudet("Vaslui Vaslui VS"));
    refJudete.add(new RefJudet("Valcea RamnicuValcea VL"));
    refJudete.add(new RefJudet("Vrancea Focsani VN"));
  }
  
  public List<RefJudet> getRefJudete(){
    return refJudete;
  }
}  
