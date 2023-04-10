package com.cebondlovu.weather4.di;


import com.cebondlovu.weather4.ui.settings.SettingsFragment;
import com.cebondlovu.weather4.ui.today.TodayFragment;
import com.cebondlovu.weather4.ui.weekly.WeeklyFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract TodayFragment contributeTodayFragment();

    @ContributesAndroidInjector
    abstract WeeklyFragment contributeWeeklyFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment contributeSettingsFragment();
}
