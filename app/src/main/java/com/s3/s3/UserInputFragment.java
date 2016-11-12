package com.s3.s3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserInputFragment extends Fragment {

    EditText rooftopArea;
    EditText avgPrice;
    Spinner indianStateSpinner;

    public UserInputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.user_input_fragment, container, false);
        rooftopArea = (EditText) rootView.findViewById(R.id.rooftop_area);
        avgPrice = (EditText) rootView.findViewById(R.id.avg_monthly_bill);
        indianStateSpinner = (Spinner) rootView.findViewById(R.id.indian_state_spinner);

        indianStateSpinner.setAdapter(new ArrayAdapter<IndianStates>(getActivity(), android.R.layout.simple_spinner_item, IndianStates.values()));
        return rootView;
    }

}
