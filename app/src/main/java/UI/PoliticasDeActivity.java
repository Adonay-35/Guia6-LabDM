package UI;

import android.os.Bundle;
import android.widget.TextView;

import com.example.guia6.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.guia6.databinding.ActivityPoliticasDeBinding;

public class PoliticasDeActivity extends AppCompatActivity {

    private ActivityPoliticasDeBinding binding;

    private TextView txtPoliticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicas_de);


    }
}