package com.example.noteapplication.di

import com.example.noteapplication.ui.authorization.AuthorizationFragment
import com.example.noteapplication.ui.dashboard.DashboardFragment
import com.example.noteapplication.ui.dashboard.add.AddNoteFragment
import com.example.noteapplication.ui.dashboard.list.NotesListFragment
import com.example.noteapplication.ui.dashboard.profile.ProfileFragment
import com.example.noteapplication.ui.dashboard.search.SearchFragment
import com.example.noteapplication.ui.distributor.DistributorFragment
import com.example.noteapplication.ui.main.MainActivity
import com.example.noteapplication.ui.registration.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, SharedPreferencesModule::class, DataBaseModule::class])
interface ApplicationComponent {

    fun inject(fragment: AuthorizationFragment)
    fun inject(fragment: AddNoteFragment)
    fun inject(fragment: NotesListFragment)
    fun inject(fragment: ProfileFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: RegistrationFragment)
    fun inject(fragment: DistributorFragment)
    fun inject(activity: MainActivity)
}