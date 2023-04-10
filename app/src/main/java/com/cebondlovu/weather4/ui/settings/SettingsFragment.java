package com.cebondlovu.weather4.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;


import com.cebondlovu.weather4.MainActivity;
import com.cebondlovu.weather4.R;
import com.cebondlovu.weather4.binding.FragmentDataBindingComponent;
import com.cebondlovu.weather4.databinding.SettingsFragmentBinding;
import com.cebondlovu.weather4.di.Injectable;
import com.cebondlovu.weather4.ui.NavigationController;
import com.cebondlovu.weather4.util.AutoClearedValue;
import com.cebondlovu.weather4.util.SharedPreferences;

import javax.inject.Inject;

public class
SettingsFragment extends DialogFragment implements Injectable {

    @Inject
    NavigationController navigationController;

    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    AutoClearedValue<SettingsFragmentBinding> binding;

    public static SettingsFragment create() {
        SettingsFragment settingsFragment = new SettingsFragment();
        return settingsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        SettingsFragmentBinding dataBinding = DataBindingUtil
                .inflate(inflater, R.layout.settings_fragment, container, false,
                        dataBindingComponent);
        binding = new AutoClearedValue<>(this, dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.get().setSettingsFragment(this);
        binding.get().setCity(SharedPreferences.getInstance(getContext()).getCity());
        binding.get().setNumDays(SharedPreferences.getInstance(getContext()).getNumDays());
        binding.get().executePendingBindings();
    }

    public void didTapCancel(View view) {
        dismiss();
    }

    public void didTapOk(View view) {

        String newCity = binding.get().etSettingsCity.getText().toString();
        String newNumDays = binding.get().etSettingsNumDays.getText().toString();

        SharedPreferences.getInstance(getContext()).putStringValue(SharedPreferences.CITY, newCity);
        SharedPreferences.getInstance(getContext()).putStringValue(SharedPreferences.NUM_DAYS, newNumDays);

        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);

        dismiss();
    }
}
