# CheckForRootAccessApp
This is an app that lets you check if the device you are using has root access and developer options 

## Check if developer options are ON or OFF

This part is done by using *Settings.Secure.getInt()* function:
```Kotlin
private fun checkForDevOptions() {
        val devOptionsEnabled = Settings.Secure.getInt(
            requireContext().contentResolver,
            Settings.Global.ADB_ENABLED,
            0
        ) != 0
        when (devOptionsEnabled) {
            true -> showToast(requireContext(), "Developer options are on")
            false -> showToast(requireContext(), "Developer options are off")
        }
    }
```
