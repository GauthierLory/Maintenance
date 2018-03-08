package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Donnee.VoyagePlanningDAO;
import voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Modele.VoyagePlanning;

public class VueModifierVoyagePlanning extends AppCompatActivity {

    protected VoyagePlanningDAO accesseurVoyagePlanning = VoyagePlanningDAO.getInstance();

    protected VoyagePlanning voyageplanning;
    protected Button modifier;
    protected Button annuler;
    protected Button supprimer;
    protected EditText champDestination;
    protected EditText champCompagnie;
    protected EditText champDate;
    protected EditText champHeure;
    protected EditText champDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_voyage_planning);

        modifier = (Button) findViewById(R.id.vue_modifier_bouton_modifier);
        annuler = (Button) findViewById(R.id.vue_modifier_bouton_annuler);
        supprimer = (Button) findViewById(R.id.vue_modifier_bouton_supprimer);
        champDestination = (EditText) findViewById(R.id.vue_modifier_destination);
        champCompagnie = (EditText) findViewById(R.id.vue_ajouter_compagnie);
        champDate = (EditText) findViewById(R.id.vue_modifier_date);
        champHeure = (EditText) findViewById(R.id.vue_modifier_heure);
        champDescription = (EditText) findViewById(R.id.vue_modifier_description);


        Bundle parametre = this.getIntent().getExtras();
        int idVoyagePlanning = Integer.parseInt((String) parametre.get("id_voyage_planning"));
        voyageplanning = accesseurVoyagePlanning.trouverVoyagePlanning(idVoyagePlanning);

        champDestination.setText(voyageplanning.getDestination());
        champCompagnie.setText(voyageplanning.getCompagnie());
        champDate.setText(voyageplanning.getDate());
        champHeure.setText(voyageplanning.getHeure());
        champDescription.setText(voyageplanning.getDescription());

      modifier.setOnClickListener(new View.OnClickListener() {

           @Override
            public void onClick(View v) {
                modifierVoyagePlanning();
                naviguerRetourVoyagePlanning();

            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                naviguerRetourVoyagePlanning();
            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supprimerVoyagePlanning();
                naviguerRetourVoyagePlanning();
            }
        });
    }

    public  void supprimerVoyagePlanning()
    {
        accesseurVoyagePlanning.supprimerVoyagePlanning(voyageplanning);
    }

    public void modifierVoyagePlanning() {
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

        accesseurVoyagePlanning.modifierVoyagePlanning(voyageplanning);

    }

    public void naviguerRetourVoyagePlanning() {
        this.finish();
    }
}

