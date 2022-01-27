package lostankit7.droid.moodtracker.ui.userEntries

class AllUserEntriesFragment : UserEntriesBaseFragment() {

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.userEntries.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    override fun init() {
        super.init()
        mActivity?.hideActionBar()
        mActivity?.showBottomNav()
    }
}