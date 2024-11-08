package UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.guia6.databinding.ActivityMain2Binding;

import java.util.ArrayList;

import Models.Presupuesto;
import UI.adapters.ChildRecyclerAdapter;
import UI.adapters.MainRecyclerAdapter;
import UI.viewModels.BudgetVM;

public class MainActivity2 extends AppCompatActivity  implements ChildRecyclerAdapter.OnItemChildClickListener {
    private ActivityMain2Binding binding;
    private BudgetVM viewModel;
    private MainRecyclerAdapter mainRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(BudgetVM.class);

        mainRecyclerAdapter = new MainRecyclerAdapter(new ArrayList<>(), MainActivity2.this);
        binding.mainRecyclerView.setAdapter(mainRecyclerAdapter);
        binding.mainRecyclerView.setHasFixedSize(true);

        viewModel.getBudgetLiveData().observe(this, budgets -> {
            mainRecyclerAdapter.setDataList(budgets);
        });

        binding.imgAgregar.setOnClickListener(v -> {

            v.animate().scaleX(0.7f).scaleY(0.7f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100);
            });

            AddBudget bottomSheet = new AddBudget();
            bottomSheet.show(getSupportFragmentManager(), "addBudgetFragment");
        });
    }


    @Override
    public void onItemChildClick(Presupuesto mainObject) {
        if (mainObject.isActivo()){
            Intent intent = new Intent(MainActivity2.this, DetailBudget.class);
            intent.putExtra("mainBudget", mainObject);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Lista Completada", Toast.LENGTH_SHORT).show();
        }
    }
}