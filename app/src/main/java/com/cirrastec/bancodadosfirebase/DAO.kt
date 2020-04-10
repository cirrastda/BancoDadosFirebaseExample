package com.cirrastec.bancodadosfirebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DAO {
    val database = Firebase.getDatabase()

    fun getCirrasTec(callback: (cirrasTec?) -> Unit) {
        database.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                for(data in p0.children) {
                    var cirrasTec = data.getValue(cirrasTec::class.java)
                    callback(cirrasTec)
                }
            }
        })


    }

    fun salvar(cirrasTec: cirrasTec) {
        database.child("cirrastec").setValue(cirrasTec)
    }
}