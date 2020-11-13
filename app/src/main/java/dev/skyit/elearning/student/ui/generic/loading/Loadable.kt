package thinkit.redesign.ui.generic.loading

interface Loadable {
    fun showLoading()
    fun hideLoading()
    var isLoading: Boolean
        get() = false
        set(value) {
            if (value) showLoading() else hideLoading()
        }
}