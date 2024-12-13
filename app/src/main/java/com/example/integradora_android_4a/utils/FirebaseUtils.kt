package com.example.integradora_android_4a.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseUtils {

    private var auth: FirebaseAuth? = null
    private var database: FirebaseDatabase? = null

    /**
     * Inicializa Firebase Authentication.
     * @return FirebaseAuth instancia autenticación.
     */
    fun getAuthInstance(): FirebaseAuth {
        if (auth == null) {
            auth = FirebaseAuth.getInstance()
        }
        return auth!!
    }

    /**
     * Inicializa Firebase Realtime Database.
     * @return FirebaseDatabase instancia de la base de datos.
     */
    fun getDatabaseInstance(): FirebaseDatabase {
        if (database == null) {
            database = FirebaseDatabase.getInstance()
        }
        return database!!
    }

    /**
     * Obtiene una referencia al nodo principal de rutas en la base de datos.
     * @return DatabaseReference referencia al nodo "routes".
     */
    fun getRoutesReference(): DatabaseReference {
        return getDatabaseInstance().getReference("routes")
    }
}