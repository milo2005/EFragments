package ezlife.movil.efragments.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import ezlife.movil.efragments.BR;
import ezlife.movil.efragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {


    public interface OnColorSelectedListener{
        void onColorSelected(int color);
    }

    OnColorSelectedListener onColorSelectedListener;
    ViewDataBinding binding;

    public ListFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onColorSelectedListener = (OnColorSelectedListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.f_list, container, false);
        binding = DataBindingUtil.bind(v);
        binding.setVariable(BR.onItemClick, this);
        return binding.getRoot();


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onColorSelectedListener.onColorSelected(position);
    }
}
