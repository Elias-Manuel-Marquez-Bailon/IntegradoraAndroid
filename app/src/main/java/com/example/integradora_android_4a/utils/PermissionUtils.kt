package com.example.integradora_android_4a.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {

    /**
     * Verifica si el permiso ya fue concedido.
     * @param activity actividad actual.
     * @param permission nombre del permiso.
     * @return true si el permiso fue concedido.
     */
    fun isPermissionGranted(activity: Activity, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Solicita permisos si no han sido concedidos.
     * @param activity actividad actual.
     * @param permissions lista de permisos a solicitar.
     * @param requestCode código de solicitud para el callback.
     */
    fun requestPermissions(activity: Activity, permissions: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    /**
     * Comprueba si todos los permisos solicitados fueron concedidos.
     * @param grantResults resultados de la solicitud de permisos.
     * @return true si todos los permisos fueron concedidos.
     */
    fun allPermissionsGranted(grantResults: IntArray): Boolean {
        return grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
    }
}