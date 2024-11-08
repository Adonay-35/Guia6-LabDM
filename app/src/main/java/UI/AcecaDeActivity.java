package UI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.guia6.databinding.ActivityAcecaDeBinding;

public class AcecaDeActivity extends AppCompatActivity {

    private ActivityAcecaDeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAcecaDeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}