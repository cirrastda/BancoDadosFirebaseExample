package com.cirrastec.bancodadosfirebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object Firebase {
    private var databaseFirebase: DatabaseReference? = null

    fun getDatabase():DatabaseReference {
        if (databaseFirebase == null) {
            val instance = FirebaseDatabase.getInstance()
            instance.setPersistenceEnabled(true)
            databaseFirebase = instance.reference
            databaseFirebase!!.keepSynced(true)
        }
        return databaseFirebase!!
    }
}