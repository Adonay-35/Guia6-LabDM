package UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.guia6.databinding.ActivityAddBudgetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import Models.Presupuesto;
import UI.viewModels.BudgetVM;

public class AddBudget extends BottomSheetDialogFragment {
    private ActivityAddBudgetBinding binding;
    private BudgetVM viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(BudgetVM.class);

        binding = ActivityAddBudgetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnGuardarPresupuesto.setOnClickListener(v -> {
            // Validación para asegurar que los campos estén llenos
            String titulo = binding.edtATitulo.getText().toString().trim();
            String montoStr = binding.edtAMonto.getText().toString().trim();

            if (titulo.isEmpty() || montoStr.isEmpty()) {
                Toast.makeText(getContext(), "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            double monto;
            try {
                monto = Double.parseDouble(montoStr);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Ingresa un monto válido", Toast.LENGTH_SHORT).show();
                return;
            }

            v.animate().scaleX(0.7f).scaleY(0.7f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100);
            });

            Presupuesto mObject = new Presupuesto(titulo, monto, true);

            viewModel.addBudget(
                    mObject,
                    documentReference -> {
                        this.dismiss();
                        Toast.makeText(getContext(), "Guardado correctamente el presupuesto", Toast.LENGTH_SHORT).show();
                    },
                    e -> {
                        Toast.makeText(getContext(), "Error: no se guardó el presupuesto", Toast.LENGTH_SHORT).show();
                    }
            );
        });


        return view;
    }
}