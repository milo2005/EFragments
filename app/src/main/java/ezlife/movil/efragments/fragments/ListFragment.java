package ezlife.movil.efragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import ezlife.movil.efragments.R;
import ezlife.movil.efragments.databinding.FragmentListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {


    public interface OnColorSelectedListener{
        void onColorSelected(int color);
    }

    FragmentListBinding binding;
    OnColorSelectedListener onColorSelectedListener;

    public ListFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onColorSelectedListener = (OnColorSelectedListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentListBinding.inflate(getLayoutInflater(savedInstanceState));
        binding.setOnItemClick(this);
        return binding.getRoot();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onColorSelectedListener.onColorSelected(position);
    }
}
