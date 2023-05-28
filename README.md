# CheckForRootAccessApp
This is an app that lets you check if the device you are using has root access and developer options 

## Check if device has Root Access

This is done by using *Runtime.getRuntime().exec("su")* command. 
The *Runtime.getRuntime().exec("su")* command is used in Android to execute a shell command with superuser (root) privileges hence if the command runs, the device has Root Access, if it doesn't - the device hasnt been "Rooted" 

```Kotlin
private fun checkForRootAccess() {
        try {
            Runtime.getRuntime().exec("su")
            showToast(requireContext(), "This Device is has Root Access")
            showToast(requireContext(), "This Device is has Root Access")
        } catch (e: IOException) {
            showToast(requireContext(), "This Device is doesn't have Root Access")
        }
    }
```

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
