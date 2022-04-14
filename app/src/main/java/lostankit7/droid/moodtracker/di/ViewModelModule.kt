package lostankit7.droid.moodtracker.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.ui.viewmodel.MoodEntryViewModel
import lostankit7.droid.moodtracker.ui.viewmodel.SplashViewModel
import lostankit7.droid.moodtracker.ui.viewmodel.TaskEntryViewModel
import lostankit7.droid.moodtracker.ui.viewmodel.UserEntriesViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MoodEntryViewModel::class)
    abstract fun bindsMoodEntryViewModel(moodEntryViewModel: MoodEntryViewModel): ViewModel

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(TaskEntryViewModel::class)
    abstract fun bindsTaskEntryViewModel(taskEntryViewModel: TaskEntryViewModel): ViewModel

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(UserEntriesViewModel::class)
    abstract fun bindsUserEntriesViewModel(userEntriesViewModel: UserEntriesViewModel): ViewModel

}