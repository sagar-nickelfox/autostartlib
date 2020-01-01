package com.app.autostartlibrary

import android.R.string
import android.app.AlertDialog
import android.content.*
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.widget.AppCompatCheckBox
import java.util.*


object AutoStartDialog {



    var POWERMANAGER_INTENTS: List<Intent> = Arrays.asList(
        Intent().setComponent(
            ComponentName(
                "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.letv.android.letvsafe",
                "com.letv.android.letvsafe.AutobootManageActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.huawei.systemmanager",
                "com.huawei.systemmanager.optimize.process.ProtectActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.coloros.safecenter",
                "com.coloros.safecenter.permission.startup.StartupAppListActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.coloros.safecenter",
                "com.coloros.safecenter.startupapp.StartupAppListActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.oppo.safe",
                "com.oppo.safe.permission.startup.StartupAppListActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.iqoo.secure",
                "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.iqoo.secure",
                "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.vivo.permissionmanager",
                "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
            )
        ),
        Intent().setComponent(
            ComponentName(
                "com.asus.mobilemanager",
                "com.asus.mobilemanager.entry.FunctionActivity"
            )
        ).setData(Uri.parse("mobilemanager://function/entry/AutoStart"))
    )


    fun startPowerSaverIntent(context: Context, msg: String) {
        val settings: SharedPreferences =
            context.getSharedPreferences("AutoStartLibSagar2020", Context.MODE_PRIVATE)
        val skipMessage = settings.getBoolean("skipProtectedAppCheck", false)
        if (!skipMessage) {
            val editor = settings.edit()
            val foundCorrectIntent: Boolean
            for (intent in POWERMANAGER_INTENTS) {
                if (isCallable(context, intent)) {
                    foundCorrectIntent = true
                    val dontShowAgain = AppCompatCheckBox(context)
                    dontShowAgain.text = "Do not show again"
                    dontShowAgain.setOnCheckedChangeListener { buttonView, isChecked ->
                        editor.putBoolean("skipProtectedAppCheck", isChecked)
                        editor.apply()
                    }
                    AlertDialog.Builder(context)
                        .setTitle(Build.MANUFACTURER + " Protected Apps")
                        .setMessage("msg") //.setView(dontShowAgain)
                        .setCancelable(false)
                        .setPositiveButton(
                            "Go to settings"
                        ) { dialog, which ->
                            if (foundCorrectIntent) {
                                editor.putBoolean("skipProtectedAppCheck", true)
                                editor.apply()
                            }
                            try {
                                if (Build.MANUFACTURER.toLowerCase() == "oppo") requestAutoStartPermission(
                                    context
                                ) else context.startActivity(
                                    intent
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            dialog.dismiss()
                        }
                        .setNegativeButton(
                            string.cancel,
                            { dialog, which -> dialog.dismiss() })
                        .show()
                    break
                }
            }
        }
    }

    private fun requestAutoStartPermission(context: Context) {
        if (Build.MANUFACTURER == "OPPO") {
            try {
                context.startActivity(
                    Intent().setComponent(
                        ComponentName(
                            "com.coloros.safecenter",
                            "com.coloros.safecenter.permission.startup.FakeActivity"
                        )
                    )
                )
            } catch (e: Exception) {
                try {
                    context.startActivity(
                        Intent().setComponent(
                            ComponentName(
                                "com.coloros.safecenter",
                                "com.coloros.safecenter.permission.startupapp.StartupAppListActivity"
                            )
                        )
                    )
                } catch (e1: Exception) {
                    try {
                        context.startActivity(
                            Intent().setComponent(
                                ComponentName(
                                    "com.coloros.safecenter",
                                    "com.coloros.safecenter.permission.startupmanager.StartupAppListActivity"
                                )
                            )
                        )
                    } catch (e2: Exception) {
                        try {
                            context.startActivity(
                                Intent().setComponent(
                                    ComponentName(
                                        "com.coloros.safe",
                                        "com.coloros.safe.permission.startup.StartupAppListActivity"
                                    )
                                )
                            )
                        } catch (e3: Exception) {
                            try {
                                context.startActivity(
                                    Intent().setComponent(
                                        ComponentName(
                                            "com.coloros.safe",
                                            "com.coloros.safe.permission.startupapp.StartupAppListActivity"
                                        )
                                    )
                                )
                            } catch (e4: Exception) {
                                try {
                                    context.startActivity(
                                        Intent().setComponent(
                                            ComponentName(
                                                "com.coloros.safe",
                                                "com.coloros.safe.permission.startupmanager.StartupAppListActivity"
                                            )
                                        )
                                    )
                                } catch (e5: Exception) {
                                    try {
                                        context.startActivity(
                                            Intent().setComponent(
                                                ComponentName(
                                                    "com.coloros.safecenter",
                                                    "com.coloros.safecenter.permission.startsettings"
                                                )
                                            )
                                        )
                                    } catch (e6: Exception) {
                                        try {
                                            context.startActivity(
                                                Intent().setComponent(
                                                    ComponentName(
                                                        "com.coloros.safecenter",
                                                        "com.coloros.safecenter.permission.startupapp.startupmanager"
                                                    )
                                                )
                                            )
                                        } catch (e7: Exception) {
                                            try {
                                                context.startActivity(
                                                    Intent().setComponent(
                                                        ComponentName(
                                                            "com.coloros.safecenter",
                                                            "com.coloros.safecenter.permission.startupmanager.startupActivity"
                                                        )
                                                    )
                                                )
                                            } catch (e8: Exception) {
                                                try {
                                                    context.startActivity(
                                                        Intent().setComponent(
                                                            ComponentName(
                                                                "com.coloros.safecenter",
                                                                "com.coloros.safecenter.permission.startup.startupapp.startupmanager"
                                                            )
                                                        )
                                                    )
                                                } catch (e9: Exception) {
                                                    try {
                                                        context.startActivity(
                                                            Intent().setComponent(
                                                                ComponentName(
                                                                    "com.coloros.safecenter",
                                                                    "com.coloros.privacypermissionsentry.PermissionTopActivity.Startupmanager"
                                                                )
                                                            )
                                                        )
                                                    } catch (e10: Exception) {
                                                        try {
                                                            context.startActivity(
                                                                Intent().setComponent(
                                                                    ComponentName(
                                                                        "com.coloros.safecenter",
                                                                        "com.coloros.privacypermissionsentry.PermissionTopActivity"
                                                                    )
                                                                )
                                                            )
                                                        } catch (e11: Exception) {
                                                            try {
                                                                context.startActivity(
                                                                    Intent().setComponent(
                                                                        ComponentName(
                                                                            "com.coloros.safecenter",
                                                                            "com.coloros.safecenter.FakeActivity"
                                                                        )
                                                                    )
                                                                )
                                                            } catch (e12: Exception) {
                                                                e12.printStackTrace()
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun isCallable(context: Context, intent: Intent): Boolean {
        val list =
            context.packageManager.queryIntentActivities(
                intent,
                PackageManager.MATCH_DEFAULT_ONLY
            )
        return list.size > 0
    }
}
