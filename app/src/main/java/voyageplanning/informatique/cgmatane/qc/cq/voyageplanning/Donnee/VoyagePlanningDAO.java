package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Donnee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Modele.VoyagePlanning;

/**
 * Created by 1732986 on 2017-09-10.
 */

public class VoyagePlanningDAO
{
    List<VoyagePlanning> listeVoyagesPlanning;

    public VoyagePlanningDAO()
    {
        listeVoyagesPlanning = new ArrayList<VoyagePlanning>();
        VoyagePlanning voyagePlanning;
        voyagePlanning = new VoyagePlanning(1, "Voyage aux U.S", "Compagnie Air Transat", "15/07/2018", "8h00", "voyage avec les parents");
        listeVoyagesPlanning.add(voyagePlanning);
        voyagePlanning = new VoyagePlanning(2, "Voyage en Inde", "Compagnie Air India", " 15/07/2019", " 8h00", "voyage avec les parents");
        listeVoyagesPlanning.add(voyagePlanning);
        voyagePlanning = new VoyagePlanning(3, "Voyage en Irlande","Compagnie Air Island", " 15/07/2020", " 8h00", "voyage avec les parents");
        listeVoyagesPlanning.add(voyagePlanning);
        voyagePlanning = new VoyagePlanning(4, "Voyage à Singapur","Compagnie Singapore Airline", " 15/07/2021", " 8h00","voyage avec les parents" );
        listeVoyagesPlanning.add(voyagePlanning);
    }

    /* PATRON singleton */
    private static VoyagePlanningDAO instance = null;
    public static VoyagePlanningDAO getInstance()
    {
        if(null == instance)
        {
            instance = new VoyagePlanningDAO();
        }
        return instance;
    }


    public VoyagePlanning trouverVoyagePlanning(int id)
    {
        for(VoyagePlanning voyageplanning : this.listeVoyagesPlanning)
        {
            if(voyageplanning.getId() == id) return voyageplanning;
        }
        return null;
    }

    public List<HashMap<String,String>> listerLesVoyagesPlanningEnHashmap()
    {
        List<HashMap<String,String>> listeVoyagesPlanningHashmap =
                new ArrayList<HashMap<String,String>>();
        for(VoyagePlanning voyagePlanning : this.listeVoyagesPlanning)
        {
            listeVoyagesPlanningHashmap.add(voyagePlanning.exporterHashMap());
        }
        return listeVoyagesPlanningHashmap;
    }

    public void modifierVoyagePlanning(VoyagePlanning voyagePlanning)
    {
        for (VoyagePlanning voyagePlanningTest : this.listeVoyagesPlanning)
        {
            if (voyagePlanningTest.getId() == voyagePlanning.getId())
            {
                voyagePlanningTest.setDestination(voyagePlanning.getDestination());
                voyagePlanningTest.setCompagnie(voyagePlanning.getCompagnie());
                voyagePlanningTest.setDate(voyagePlanning.getDate());
                voyagePlanningTest.setHeure(voyagePlanning.getHeure());
                voyagePlanningTest.setDescription(voyagePlanning.getDescription());
                return;
            }
        }
    }

    public void supprimerVoyagePlanning(VoyagePlanning voyagePlanning)
    {
        listeVoyagesPlanning.remove(voyagePlanning);
    }

    public void ajouterVoyagePlanning (VoyagePlanning voyagePlanning)
    {
        listeVoyagesPlanning.add(voyagePlanning);
    }

}
