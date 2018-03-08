package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Donnee.VoyagePlanningDAO;

public class VueVoyagePlanning extends AppCompatActivity {

    protected VoyagePlanningDAO accesseurVoyagePlanning;
    protected List<HashMap<String, String>> listeVoyagesPlanning;
    protected ListView vueListeVoyagesPlanning;
    protected Button ajouter;

    static public final int ACTIVITE_MODIFIER_VOYAGE_PLANNING = 1;
    static final public int ACTIVITE_AJOUTER_VOYAGE_PLANNING = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_voyage_planning);

        ajouter = (Button) findViewById(R.id.vue_bouton_ajouter);
        ajouter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intentionNaviguerAjouterVoyagePlanning = new Intent (VueVoyagePlanning.this,VueAjouterVoyagePlanning.class);
                startActivityForResult(intentionNaviguerAjouterVoyagePlanning,ACTIVITE_AJOUTER_VOYAGE_PLANNING);
            }
        });

        vueListeVoyagesPlanning = (ListView)findViewById(R.id.vue_planning);
        vueListeVoyagesPlanning.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View vue, int positionDansAdapteur, long positionItem)
            {
                ListView vueListeVoyagesPlanning = (ListView)vue.getParent();
                HashMap<String, String> voyageplanning = (HashMap<String, String>)vueListeVoyagesPlanning.getItemAtPosition((int)positionItem);

                Intent intentionNaviguerModifierVoyagePlanning = new Intent( VueVoyagePlanning.this, VueModifierVoyagePlanning.class);
                intentionNaviguerModifierVoyagePlanning.putExtra("id_voyage_planning", voyageplanning.get("id_voyage_planning"));
                startActivityForResult(intentionNaviguerModifierVoyagePlanning,ACTIVITE_MODIFIER_VOYAGE_PLANNING);
            }
        });
                accesseurVoyagePlanning = VoyagePlanningDAO.getInstance();
        afficherTousLesVoyagesPlanning();
    }

    public void afficherTousLesVoyagesPlanning()
    {
        listeVoyagesPlanning = accesseurVoyagePlanning.listerLesVoyagesPlanningEnHashmap();

        SimpleAdapter adapteurVueListeVoyagesPlanning = new SimpleAdapter(
                this,
                listeVoyagesPlanning,
                android.R.layout.two_line_list_item,
                new String[] {"destination","compagnie"},
                new int[] {android.R.id.text1, android.R.id.text2});
        vueListeVoyagesPlanning.setAdapter(adapteurVueListeVoyagesPlanning);
    }
    protected void onActivityResult(int activite, int resultat, Intent donnees)
    {
        switch(activite)
        {
            case ACTIVITE_MODIFIER_VOYAGE_PLANNING:
                afficherTousLesVoyagesPlanning();
                break;
            case ACTIVITE_AJOUTER_VOYAGE_PLANNING:
                afficherTousLesVoyagesPlanning();
                break;
        }

    }
}
