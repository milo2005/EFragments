package ezlife.movil.efragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ezlife.movil.efragments.R;
import ezlife.movil.efragments.databinding.FragmentColorBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    public static final int COLOR_AZUL = 0;
    public static final int COLOR_AMARILLO = 1;
    public static final int COLOR_VERDE = 2;
    public static final int COLOR_NARANJA = 3;
    public static final int COLOR_VIOLETA = 4;
    public static final int COLOR_ROJO = 5;

    FragmentColorBinding binding;
    String[] colores;
    int[] coloresValor;

    int color;

    public ColorFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        colores = context.getResources().getStringArray(R.array.colores);
        coloresValor = context.getResources().getIntArray(R.array.colores_valor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColorBinding.inflate(getLayoutInflater(savedInstanceState));
        setColor(color);
        return binding.getRoot();
    }

    public void setColor(int color){
        if(binding!=null){
            binding.setNombre(colores[color]);
            binding.setColor(coloresValor[color]);
        }

        this.color = color;

    }

}
