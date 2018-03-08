package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Donnee.VoyagePlanningDAO;
import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Modele.VoyagePlanning;

public class VueAjouterVoyagePlanning extends AppCompatActivity {

    protected VoyagePlanningDAO accesseurVoyagePlanning = VoyagePlanningDAO.getInstance();
    protected VoyagePlanning voyageplanning;
    protected Button modifier;
    protected Button annuler;
    protected EditText champDestination;
    protected EditText champCompagnie;
    protected EditText champDate;
    protected EditText champHeure;
    protected EditText champDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_voyage_planning);

        modifier = (Button) findViewById(R.id.vue_ajouter_bouton_modifier);
        annuler = (Button) findViewById(R.id.vue_ajouter_bouton_annuler);
        champDestination = (EditText) findViewById(R.id.vue_ajouter_destination);
        champCompagnie = (EditText) findViewById(R.id.vue_ajouter_compagnie);
        champDate = (EditText) findViewById(R.id.vue_ajouter_date);
        champHeure = (EditText) findViewById(R.id.vue_ajouter_heure);
        champDescription = (EditText) findViewById(R.id.vue_ajouter_description);

        modifier.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ajouterVoyagePlanning();
                naviguerRetourVoyagePlanning();
            }
      });

        annuler.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    naviguerRetourVoyagePlanning();
                }
            });

    }
    public void ajouterVoyagePlanning()
    {
        voyageplanning = new VoyagePlanning();

        String destination = champDestination.getText().toString();
        String compagnie = champCompagnie.getText().toString();
        String date = champDate.getText().toString();
        String heure = champHeure.getText().toString();
        String description = champDescription.getText().toString();

        voyageplanning.setDestination(destination);
        voyageplanning.setCompagnie(compagnie);
        voyageplanning.setDate(date);
        voyageplanning.setHeure(heure);
        voyageplanning.setDescription(description);

        accesseurVoyagePlanning.ajouterVoyagePlanning(voyageplanning);
    }



   public void naviguerRetourVoyagePlanning()
    {
                this.finish();
    }
}