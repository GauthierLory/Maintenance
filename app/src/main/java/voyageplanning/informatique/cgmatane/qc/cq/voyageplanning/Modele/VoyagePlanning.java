package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Modele;

import java.util.HashMap;

/**
 * Created by 1732986 on 2017-09-10.
 */

public class VoyagePlanning
{
        protected int id;
        protected String destination;
        protected String compagnie;
        protected String date;
        protected String heure;
        protected String transport;
        protected String description;

    public  VoyagePlanning(){

    }

    public VoyagePlanning(int id, String destination, String compagnie, String date, String heure)
    {
        this.id = id;
        this.destination = destination;
        this.compagnie = compagnie;
        this.date = date;
        this.heure = heure;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getTransport() { return transport; }

    public void setTransport(String transport) { this.transport = transport; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public HashMap<String,String> exporterHashMap()
    {
        HashMap<String,String> voyagePlanning = new HashMap<String,String>();
        voyagePlanning.put("id_voyage_planning", String.valueOf(this.id) );
        voyagePlanning.put("destination", this.destination);
        voyagePlanning.put("compagnie", this.compagnie);
        voyagePlanning.put("date", this.date);
        voyagePlanning.put("heure", this.heure);
        voyagePlanning.put("transport", this.transport);
        voyagePlanning.put("description", this.description);

        return voyagePlanning;
    }


}
